package com.ohgiraffers.restapi.responseentity.service;

import com.ohgiraffers.restapi.responseentity.repository.PokemonRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private final PokemonRepository menuRepository;
    private final ModelMapper modelMapper;

    public PokemonService(PokemonRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * pokemon 정보를 받아서 Pokemon Entity 로 만들고
     * Pokemon Entity 객체를 데이터베이스에 저장
     */

    public PokemonService(PokemonRepository pokemonRepository, ModelMapper modelMapper) {
        this.pokemon
    }
//    this.pokemonservice = pokemonservice;
//    this.pokemonmapper = modelMapper;
//    this.categoryRepository = categoryRepository;
}



package com.ohgiraffers.springdatajpa.menu.model.service;

import com.ohgiraffers.springdatajpa.menu.model.dto.CategoryDto;
import com.ohgiraffers.springdatajpa.menu.model.dto.MenuDto;
import com.ohgiraffers.springdatajpa.menu.model.entity.Category;
import com.ohgiraffers.springdatajpa.menu.model.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.model.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.model.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }



        Pokemon menu = menuRepository.findById(pokemonCode)
                .orElseThrow(IllegalArgumentException::new);

        log.info("menu ============ {}", menu);

        return modelMapper.map(menu, MenuDto.class);
    }

    public List<MenuDto> findMenuList() {

        List<Menu> menulist =
                menuRepository.findAll();
//                menuRepository.findAll(Sort.by("menuPrice").descending());

        return menulist.stream()
                .map(menu -> modelMapper.map(menu, MenuDto.class))
                .collect(Collectors.toList());
    }

    public Page<MenuDto> findAllMenus(Pageable pageable) {



        pageable = PageRequest.of( // PageRequest.of -> Pageable 객체 조작
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending());

        Page<Menu> menuList = menuRepository.findAll(pageable);

        return menuList.map(menu -> modelMapper.map(menu, MenuDto.class));
    }

    public List<MenuDto> findByMenuPrice(Integer menuPrice) {

        List<Menu> menuList = null;


        if(menuPrice == 0) {
            menuList = menuRepository.findAll();
        } else if (menuPrice > 0) {
            menuList =
                    menuRepository.findByMenuPriceEquals(menuPrice);
        }

        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDto.class))
                .collect(Collectors.toList());
    }

    public List<CategoryDto> findAllCategory() {


        // NativeQuery
        List<Category> categoryList = categoryRepository.findAllCategoryByNativeQuery();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void registNewMenu(MenuDto newMenu) {

        Menu menu = modelMapper.map(newMenu, Menu.class);


        menuRepository.save(menu);
    }

    @Transactional
    public void modifyMenu(MenuDto modifyMenu) {


        log.info("modifyMenu ===========> {}", modifyMenu);
        Menu foundMenu = menuRepository.findById(modifyMenu.getMenuCode())
                .orElseThrow(() -> new IllegalArgumentException("Menu not found"));

        foundMenu.setMenuName(modifyMenu.getMenuName());

//        foundMenu = foundMenu.toBuilder()
//                    .menuName(modifyMenu.getMenuName())
//                    .build();

        log.info("foundMenu ==========> {}", foundMenu);
    }

    @Transactional
    public void deleteMenu(Integer menuCode) {

        menuRepository.deleteById(menuCode);
    }
}

