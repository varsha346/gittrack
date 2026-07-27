package com.varsha.gittrack.service;

import com.varsha.gittrack.dto.repository.CreateRepositoryInput;
import com.varsha.gittrack.dto.repository.UpdateRepositoryInput;
import com.varsha.gittrack.entity.GitRepository;
import com.varsha.gittrack.entity.User;
import com.varsha.gittrack.repository.GitRepositoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GitRepositoryService {

    private final GitRepositoryRepository gitRepositoryRepository;
    private final UserService userService;

    public GitRepository createRepository(CreateRepositoryInput input) {

        User owner = userService.getCurrentUser();

        gitRepositoryRepository.findByNameAndOwner(input.getName(), owner)
                .ifPresent(repo -> {
                    throw new RuntimeException("Repository with this name already exists.");
                });

        GitRepository repository = new GitRepository();

        repository.setName(input.getName());
        repository.setDescription(input.getDescription());
        repository.setVisibility(input.getVisibility());
        repository.setOwner(owner);

        return gitRepositoryRepository.save(repository);
    }

    public GitRepository getRepositoryById(Long id) {

        return gitRepositoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repository not found"));
    }

    public List<GitRepository> getAllRepositories() {

        return gitRepositoryRepository.findAll();
    }

    public List<GitRepository> getMyRepositories() {

        User currentUser = userService.getCurrentUser();

        return gitRepositoryRepository.findByOwner(currentUser);
    }

    public GitRepository updateRepository(UpdateRepositoryInput input) {

        GitRepository repository = getRepositoryById(input.getId());

        User currentUser = userService.getCurrentUser();

        if (!repository.getOwner().getId().equals(currentUser.getId())) {
            throw new RuntimeException("You are not allowed to update this repository.");
        }

        if (input.getDescription() != null) {
            repository.setDescription(input.getDescription());
        }

        if (input.getVisibility() != null) {
            repository.setVisibility(input.getVisibility());
        }

        return gitRepositoryRepository.save(repository);
    }

    public Boolean deleteRepository(Long id) {

        GitRepository repository = getRepositoryById(id);

        User currentUser = userService.getCurrentUser();

        if (!repository.getOwner().getId().equals(currentUser.getId())) {
            throw new RuntimeException("You are not allowed to delete this repository.");
        }

        gitRepositoryRepository.delete(repository);

        return true;
    }
}