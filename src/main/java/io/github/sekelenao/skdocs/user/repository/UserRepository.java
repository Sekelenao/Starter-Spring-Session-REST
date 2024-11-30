package io.github.sekelenao.skdocs.user.repository;

import io.github.sekelenao.skdocs.user.dto.send.PublicUserInfos;
import io.github.sekelenao.skdocs.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Retrieves a {@link UserEntity} by its username.
     *
     * @param username the username of the user to find
     * @return an {@link Optional} containing the found {@link UserEntity},
     *         or an empty {@link Optional} if no user is found with the given username
     */
    Optional<UserEntity> findByUsername(String username);

    /**
     * Converts a {@link UserEntity} into a {@link PublicUserInfos} object.
     *
     * <p>This static method maps relevant fields from a {@link UserEntity} to
     * a {@link PublicUserInfos} object, which contains publicly accessible user information.</p>
     *
     * @param userEntity the {@link UserEntity} to convert
     * @return a {@link PublicUserInfos} object containing the user's public information
     * @throws NullPointerException if the {@link UserEntity} is null
     */
    static PublicUserInfos toPublicUserInfos(UserEntity userEntity) {
        Objects.requireNonNull(userEntity);
        return new PublicUserInfos(
                userEntity.getId(),
                userEntity.getDisplayName()
        );
    }

}

