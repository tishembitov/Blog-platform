package ru.tishembitov.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.tishembitov.blog.model.CreatePostRequest;
import ru.tishembitov.blog.model.UpdatePostRequest;
import ru.tishembitov.blog.model.dto.CreatePostRequestDto;
import ru.tishembitov.blog.model.dto.PostDto;
import ru.tishembitov.blog.model.dto.UpdatePostRequestDto;
import ru.tishembitov.blog.model.entity.Post;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "status", source = "status")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);

}
