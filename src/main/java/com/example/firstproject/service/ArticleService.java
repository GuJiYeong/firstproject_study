package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;    // 게시글 리파지터리 객체 주입

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article=dto.toEntity();
        if(article.getId()!=null){
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        // DTO -> 엔티티 변환
        Article article=dto.toEntity();
        log.info("id: {}, article: {}",id, article.toString());
        // 타깃 조회
        Article target=articleRepository.findById(id).orElse(null);
        // 잘못된 요청 처리
        if(target==null || id!=article.getId()){
            return null;
        }
        // 업데이트 및 정상 응답
        target.patch(article);
        Article updated=articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id) {
        // 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 잘못된 요청 처리하기
        if (target == null) {
            return null;
        }
        // 대상 삭제하기
        articleRepository.delete(target);
        return target;
//        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        // dto 묶음을 엔티티 묶음으로 변환하기
        List<Article> articleList=dtos.stream()
                .map(dto->dto.toEntity()).collect(Collectors.toList());
        // 엔티티 묶음을 DB 에 저장하기
        articleList.stream()
                .forEach(article -> articleRepository.save(article));
        // 강제 예외 발생시키기
        articleRepository.findById(-1L).orElseThrow(()->new IllegalArgumentException("결제 실패!"));
        // 결과값 반환하기
        return articleList;
    }
}
