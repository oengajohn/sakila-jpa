package io.github.oengajohn.sakilaappjpa.component;

import io.github.oengajohn.sakilaappjpa.controller.dto.*;
import io.github.oengajohn.sakilaappjpa.entity.*;
import org.springframework.beans.BeanUtils;


public class DtoMapper {

    public static Actor mapToActorEntity(ActorDto source) {
        var target = new Actor();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static  ActorDto mapToActorDto(Actor source) {
        var target = new ActorDto();
        BeanUtils.copyProperties(source, target);
        return target;
    }
    public static User mapToUserEntity(UserDto source) {
        var target = new User();
        BeanUtils.copyProperties(source, target);
        //TODO: adjust password field to be saved
        target.setUserPassword(PasswordHasher.hashPassword(source.getUsername()));
        target.setGroup(Group.builder().id(source.getGroupId()).build());

        return target;
    }
    public static UserDto mapToUserDto(User source) {
        var target = new UserDto();
        BeanUtils.copyProperties(source,target);
        target.setGroupId(source.getGroup().getId());
        target.setGroup(mapToGroupDto(source.getGroup()));
        return target;
    }


    public static Group mapToGroupEntity(GroupDto source) {
        var target = new Group();
        BeanUtils.copyProperties(source, target);
        return target;
    }
    public static GroupDto mapToGroupDto(Group source) {
        var target = new GroupDto();
        BeanUtils.copyProperties(source,target);
        return target;
    }
    public static Film mapToFilmEntity(FilmDto source) {
        var target = new Film();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static FilmDto mapToFilmDto(Film source) {
        var target = new FilmDto();
        BeanUtils.copyProperties(source, target);
        target.setLanguageId(source.getLanguage().getId());
        Language originalLanguage = source.getOriginalLanguage();
        target.setOriginalLanguageId(originalLanguage!=null ? originalLanguage.getId():null);
        return target;
    }
    public static Category mapToCategoryEntity(CategoryDto source) {
        var target = new Category();
        BeanUtils.copyProperties(source, target);
        return target;
    }
    public static CategoryDto mapToCategoryDto(Category source) {
        var target = new CategoryDto();
        BeanUtils.copyProperties(source,target);
        return target;
    }
    public static Language mapToLanguageEntity(LanguageDto source) {
        var target = new Language();
        BeanUtils.copyProperties(source, target);
        return target;
    }
    public static LanguageDto mapToLanguageDto(Language source) {
        var target = new LanguageDto();
        BeanUtils.copyProperties(source,target);
        return target;
    }
    public static Country mapToCountryEntity(CountryDto source) {
        var target = new Country();
        BeanUtils.copyProperties(source, target);
        return target;
    }
    public static CountryDto mapToCountryDto(Country source) {
        var target = new CountryDto();
        BeanUtils.copyProperties(source,target);
        return target;
    }
    public static City mapToCityEntity(CityDto source) {
        var target = new City();
        BeanUtils.copyProperties(source, target);
        return target;
    }
    public static CityDto mapToCityDto(City source) {
        var target = new CityDto();
        BeanUtils.copyProperties(source,target);
        Country country = source.getCountry();
        target.setCountryId(country.getId());
        target.setCountry(mapToCountryDto(country));
        return target;
    }

}
