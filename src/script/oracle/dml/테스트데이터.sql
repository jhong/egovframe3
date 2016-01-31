
-- 로그인 없이 /indexDev.do 접근 가능하도록 추가
INSERT INTO "COMTNROLEINFO" (ROLE_CODE, ROLE_NM, ROLE_PTTRN, ROLE_DC, ROLE_TY, ROLE_SORT, ROLE_CREAT_DE) VALUES ('web-000021', '개발 index page', '/indexDev.do', '개발 index page에 대한 접근 제한 롤', 'url', '1', '15/12/25            ')
INSERT INTO "COMTNAUTHORROLERELATE" (AUTHOR_CODE, ROLE_CODE, CREAT_DT) VALUES ('ROLE_ANONYMOUS', 'web-000021', TO_DATE('15/12/25', 'RR/MM/DD'))


-- 로그인 없이 /cmm/main/mainPage.do 접근 가능하도록 추가
INSERT INTO "COMTNROLEINFO" (ROLE_CODE, ROLE_NM, ROLE_PTTRN, ROLE_DC, ROLE_TY, ROLE_SORT, ROLE_CREAT_DE) VALUES ('web-000022', '템플릿 메인페이지', '/cmm/main/mainPage.do', '템플릿 메인페이지에 대한 접근 제한 롤', 'url', '1', '15/12/25            ')
INSERT INTO "COMTNAUTHORROLERELATE" (AUTHOR_CODE, ROLE_CODE, CREAT_DT) VALUES ('IS_AUTHENTICATED_ANONYMOUSLY', 'web-000022', TO_DATE('15/12/25', 'RR/MM/DD'))
