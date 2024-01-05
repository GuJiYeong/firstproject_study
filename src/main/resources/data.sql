INSERT INTO article(id, title, content)
VALUES (1, '가가가가', '1111');
INSERT INTO article(id, title, content)
VALUES (2, '나나나나', '2222');
INSERT INTO article(id, title, content)
VALUES (3, '다다다다', '3333');

INSERT INTO article(id, title, content)
VALUES(4, '당신의 인생 영화는?', '댓글 고');
INSERT INTO article(id, title, content)
VALUES(5, '당신의 소울 푸드는?', '댓글 고고');
INSERT INTO article(id, title, content)
VALUES(6, '당신의 취미는?', '댓글 고고고');

INSERT INTO comment(article_id, nickname, body)
VALUES(4, 'park', '굿 윌 헌팅');
INSERT INTO comment(article_id, nickname, body)
VALUES(4, 'Kim', '아이 엠 샘');
INSERT INTO comment(article_id, nickname, body)
VALUES(4, 'choi', '쇼생크 탈출');

INSERT INTO comment(article_id, nickname, body)
VALUES(5, 'park', '치킨');
INSERT INTO comment(article_id, nickname, body)
VALUES(5, 'Kim', '샤브샤브');
INSERT INTO comment(article_id, nickname, body)
VALUES(5, 'choi', '초밥');

INSERT INTO comment(article_id, nickname, body)
VALUES(6, 'park', '조깅');
INSERT INTO comment(article_id, nickname, body)
VALUES(6, 'Kim', '유튜브 시청');
INSERT INTO comment(article_id, nickname, body)
VALUES(6, 'choi', '독서');