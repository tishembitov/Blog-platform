package ru.tishembitov.blog.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import ru.tishembitov.blog.model.dto.CategoryDto;
import ru.tishembitov.blog.model.dto.CreateCategoryRequest;
import ru.tishembitov.blog.model.entity.Category;
import ru.tishembitov.blog.model.entity.Post;
import ru.tishembitov.blog.model.enums.PostStatus;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source="posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if(null == posts) {
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
