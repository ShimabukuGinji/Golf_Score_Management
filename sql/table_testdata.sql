CREATE DATABASE golf_score;

CREATE TABLE users(
    id SERIAL PRIMARY KEY
    , name VARCHAR(255) NOT NULL
    , display_name VARCHAR(255) NOT NULL
    , login_id VARCHAR(255) NOT NULL UNIQUE
    , password VARCHAR(255) NOT NULL
    , role INT NOT NULL
);

CREATE TABLE courses(
    id SERIAL PRIMARY KEY
    , name VARCHAR(255) NOT NULL
    , place VARCHAR(20) NOT NULL
    , par_all INT NOT NULL
    , par_hole1 INT NOT NULL
    , par_hole2 INT NOT NULL
    , par_hole3 INT NOT NULL
    , par_hole4 INT NOT NULL
    , par_hole5 INT NOT NULL
    , par_hole6 INT NOT NULL
    , par_hole7 INT NOT NULL
    , par_hole8 INT NOT NULL
    , par_hole9 INT NOT NULL
    , par_hole10 INT NOT NULL
    , par_hole11 INT NOT NULL
    , par_hole12 INT NOT NULL
    , par_hole13 INT NOT NULL
    , par_hole14 INT NOT NULL
    , par_hole15 INT NOT NULL
    , par_hole16 INT NOT NULL
    , par_hole17 INT NOT NULL
    , par_hole18 INT NOT NULL
);

CREATE TABLE scores(
    id SERIAL PRIMARY KEY
    , user_id INT NOT NULL
    , play_date DATE
    , course_id INT NOT NULL
    , note VARCHAR(2000)
);

CREATE TABLE hole1(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole2(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole3(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole4(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole5(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole6(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole7(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole8(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole9(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole10(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole11(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole12(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole13(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole14(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole15(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole16(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole17(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

CREATE TABLE hole18(
    id SERIAL PRIMARY KEY
    , score INT NOT NULL
    , patts INT NOT NULL
    , bunker INT
    , water INT
    , ob INT
    , pena INT
);

INSERT INTO users (name, display_name, login_id, password, role) VALUES
('システム管理者', '管理者', 'admin', 'admin', 1),
('田中太郎', 'Taro', 'tanaka', 'pass01', 2),
('山田花子', 'Hanako', 'yamada', 'pass02', 2),
('佐藤健太', 'Kenta', 'sato', 'pass03', 2),
('鈴木美智子', 'Michiko', 'suzuki', 'pass04', 2);

INSERT INTO courses (name, place, par_all, par_hole1, par_hole2, par_hole3, par_hole4, par_hole5, par_hole6, par_hole7, par_hole8, par_hole9, par_hole10, par_hole11, par_hole12, par_hole13, par_hole14, par_hole15, par_hole16, par_hole17, par_hole18)
VALUES 
('サンセットリーフ', 'okinawa', 72, 5, 4, 3, 4, 5, 4, 4, 4, 3, 4, 3, 5, 4, 5, 4, 3, 4, 4)
, ('パシフィックウェーブ', 'naha', 72, 3, 4, 4, 4, 4, 3, 5, 5, 4, 5, 4, 4, 4, 3, 4, 4, 3, 5)
, ('グリーンパラダイス', 'tomisiro', 72, 3, 5, 4, 4, 5, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 3, 4, 4)
, ('オーシャンディランド', 'ginowan', 72, 5, 5, 4, 3, 4, 4, 5, 3, 3, 4, 4, 3, 5, 4, 5, 4, 3, 4)
, ('パームビーチクラブ', 'itoman', 72, 5, 3, 4, 4, 5, 3, 4, 4, 4, 3, 4, 4, 5, 5, 4, 3, 3, 4)
, ('イーグルパーク', 'chatan', 72, 4, 3, 4, 5, 5, 4, 4, 3, 4, 4, 5, 3, 4, 4, 5, 3, 4, 4)
, ('デルタシャイン', 'nago', 72, 3, 4, 5, 4, 5, 4, 4, 3, 4, 5, 4, 4, 3, 4, 5, 3, 4, 4)
, ('オーシャンプリンセス', 'uruma', 72, 4, 5, 4, 4, 3, 4, 3, 4, 5, 5, 3, 4, 4, 4, 4, 5, 4, 3)
, ('グリーンビーチリゾート', 'okinawa', 72, 5, 5, 4, 3, 4, 4, 4, 3, 4, 4, 4, 4, 3, 5, 3, 5, 4, 4)
, ('サンライズカントリークラブ', 'ginowan', 72, 3, 4, 4, 4, 4, 3, 5, 5, 4, 5, 4, 4, 4, 3, 4, 4, 3, 5)
, ('ブルーウォータークランク', 'naha', 72, 4, 5, 4, 4, 4, 4, 3, 3, 5, 3, 4, 5, 4, 4, 4, 4, 5, 3)
, ('ロイヤルパークリゾート', 'uruma', 72, 5, 4, 3, 4, 5, 4, 4, 4, 3, 4, 3, 5, 4, 5, 4, 3, 4, 4)
, ('グリーンヒルズカントリー倶楽部', 'tomisiro', 72, 5, 5, 4, 3, 4, 4, 4, 3, 4, 4, 4, 4, 3, 5, 3, 5, 4, 4)
, ('マリンドリームハイツ', 'sesoko', 72, 3, 5, 4, 4, 5, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 3, 4, 4)
, ('グリーンウェイカントリーパーク', 'sesoko', 72, 3, 4, 5, 4, 5, 4, 4, 3, 4, 5, 4, 4, 3, 4, 5, 3, 4, 4)
, ('オークウッドクラブ', 'sesoko', 72, 4, 3, 4, 5, 5, 4, 4, 3, 4, 4, 5, 3, 4, 4, 5, 3, 4, 4)
, ('ロングビーチカントリーリゾート', 'sesoko', 72, 5, 5, 4, 3, 4, 4, 5, 3, 3, 4, 4, 3, 5, 4, 5, 4, 3, 4)
, ('パシフィックシーサイド', 'sesoko', 72, 5, 5, 4, 3, 4, 4, 4, 3, 4, 4, 4, 4, 3, 5, 3, 5, 4, 4)
, ('サンライズビーチパーク', 'sesoko', 72, 5, 3, 4, 4, 5, 3, 4, 4, 4, 3, 4, 4, 5, 5, 4, 3, 3, 4)
, ('シーサイドリゾートカントリー', 'sesoko', 72, 4, 5, 4, 4, 4, 4, 3, 3, 5, 3, 4, 5, 4, 4, 4, 4, 5, 3);

INSERT INTO scores (user_id, play_date, course_id, note)
VALUES 
(2, '2023-06-01', 1, 'Great shot on the first hole!')
, (2, '2023-09-11', 4, 'Missed the green on the second hole')
, (2, '2023-10-04', 5, 'Hole-in-one on the third hole!')
, (2, '2023-11-25', 2, 'Played a great game of golf today!')
, (2, '2024-01-07', 5, 'Lost my ball in the water on the fifth hole')
, (2, '2024-01-30', 11, 'Finally broke my score record on the sixth hole!')
, (2, '2024-02-10', 8, 'Tough course today, but I hung in there')
, (2, '2024-05-15', 1, 'Played with my friend today and we had a great time!')
, (2, '2024-05-22', 17, 'My friends swing is really improving!')
, (2, '2024-06-02', 20, 'Golfing is my favorite way to relax');

INSERT INTO hole1 (score, patts, bunker, water, ob, pena) 
VALUES 
    (4, 2, 1, 0, 0, 0)
    ,(5, 3, 2, 1, 0, 0)
    ,(3, 1, 0, 0, 1, 0)
    ,(4, 2, 1, 0, 0, 1)
    ,(5, 2, 3, 2, 0, 0)
    ,(4, 1, 2, 1, 0, 1)
    ,(3, 2, 1, 0, 1, 0)
    ,(5, 2, 0, 0, 0, 1)
    ,(4, 1, 0, 0, 0, 0)
    ,(5, 3, 3, 2, 0 ,0);


INSERT INTO hole2 (score, patts, bunker, water, ob, pena)
VALUES 
    (3, 4, 1, 0, 0, 0)
    ,(4, 3, 2, 1, 0, 0)
    ,(2, 5, 0, 0, 0, 0)
    ,(5, 2, 3, 1, 0, 0)
    ,(4, 4, 2, 0, 1, 0)
    ,(3, 3, 1, 0, 1, 0)
    ,(2, 2, 1, 0, 0, 0)
    ,(5, 3, 2, 1, 1, 0)
    ,(4, 5, 1, 0, 1, 0)
    ,(3, 2, 2, 0, 0, 1);


INSERT INTO hole3 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 2, 1, 0, 0, 0),
    (3, 3, 2, 0, 1, 0),
    (5, 1, 0, 0, 0, 1),
    (2, 4, 1, 1, 0, 0),
    (6, 2, 2, 0, 0, 1),
    (4, 3, 1, 0, 1, 0),
    (5, 2, 1, 1, 0, 1),
    (3, 4, 2, 0, 0, 1),
    (6, 3, 0, 1, 1, 0),
    (4, 2, 2, 1, 0, 1);
    
INSERT INTO hole4 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 3, 0, 0, 1, 2),
    (3, 2, 1, 0, 0, 1),
    (5, 4, 0, 1, 0, 0),
    (2, 1, 2, 0, 0, 2),
    (4, 3, 1, 0, 1, 1),
    (3, 2, 0, 1, 0, 2),
    (5, 4, 0, 0, 1, 0),
    (2, 1, 1, 1, 0, 3),
    (4, 3, 0, 0, 0, 1),
    (3, 2, 1, 0, 1, 2);
    
INSERT INTO hole5 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 3, 0, 0, 0, 0),
    (3, 4, 1, 0, 0, 1),
    (5, 2, 0, 1, 0, 0),
    (2, 5, 1, 1, 0, 2),
    (4, 3, 0, 0, 1, 0),
    (3, 4, 0, 1, 1, 1),
    (5, 2, 1, 0, 1, 1),
    (2, 5, 0, 0, 2, 2),
    (4, 3, 1, 1, 0, 1),
    (3, 4, 1, 0, 2, 2);

INSERT INTO hole6 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 3, 0, 0, 0, 0),
    (3, 2, 1, 0, 0, 1),
    (5, 4, 0, 1, 0, 0),
    (2, 1, 0, 0, 1, 0),
    (6, 5, 1, 0, 0, 0),
    (3, 2, 0, 1, 1, 0),
    (4, 3, 1, 0, 0, 1),
    (2, 1, 0, 0, 0, 2),
    (5, 4, 0, 1, 1, 0),
    (3, 2, 1, 1, 0, 1);
    
INSERT INTO hole7 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 3, 0, 0, 0, 0),
    (5, 2, 1, 0, 0, 0),
    (4, 4, 0, 1, 0, 0),
    (3, 3, 0, 0, 1, 0),
    (5, 2, 1, 1, 0, 0),
    (4, 4, 1, 0, 0, 0),
    (3, 3, 0, 1, 1, 0),
    (4, 2, 1, 1, 1, 0),
    (5, 3, 2, 0, 0, 0),
    (3, 4, 1, 1, 2, 1);


INSERT INTO hole8 (score, patts, bunker, water, ob, pena)
VALUES
    (3, 2, 0, 0, 0, 1),
    (4, 1, 1, 0, 0, 0),
    (2, 3, 0, 1, 0, 1),
    (5, 1, 1, 0, 1, 0),
    (3, 2, 1, 0, 0, 1),
    (2, 4, 0, 0, 0, 0),
    (4, 2, 0, 1, 1, 0),
    (5, 1, 0, 0, 0, 2),
    (3, 3, 1, 1, 0, 1),
    (2, 2, 0, 0, 1, 1);
    
INSERT INTO hole9 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 3, 0, 0, 0, 0),
    (5, 4, 1, 0, 0, 1),
    (3, 2, 0, 0, 0, 0),
    (4, 3, 1, 0, 0, 1),
    (3, 2, 0, 1, 0, 1),
    (5, 4, 1, 1, 0, 2),
    (4, 3, 0, 1, 1, 2),
    (3, 2, 0, 0, 1, 1),
    (5, 4, 1, 0, 1, 2),
    (4, 3, 0, 0, 0, 0);

INSERT INTO hole10 (score, patts, bunker, water, ob, pena) 
VALUES 
    (4, 2, 1, 0, 0, 0)
    ,(5, 3, 2, 1, 0, 0)
    ,(3, 1, 0, 0, 1, 0)
    ,(4, 2, 1, 0, 0, 1)
    ,(5, 4, 3, 2, 0, 0)
    ,(4, 3, 2, 1, 0, 1)
    ,(3, 2, 1, 0, 1, 0)
    ,(5, 2, 0, 0, 0, 1)
    ,(4, 1, 0, 0, 0, 0)
    ,(5, 4, 3, 2, 0 ,0);


INSERT INTO hole11 (score, patts, bunker, water, ob, pena)
VALUES 
    (3, 4, 1, 0, 0, 0)
    ,(4, 3, 2, 1, 0, 0)
    ,(2, 5, 0, 0, 0, 0)
    ,(5, 2, 3, 1, 0, 0)
    ,(4, 4, 2, 0, 1, 0)
    ,(3, 3, 1, 0, 1, 0)
    ,(2, 2, 1, 0, 0, 0)
    ,(5, 3, 2, 1, 1, 0)
    ,(4, 5, 1, 0, 1, 0)
    ,(3, 2, 2, 0, 0, 1);


INSERT INTO hole12 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 2, 1, 0, 0, 0),
    (3, 3, 2, 0, 1, 0),
    (5, 1, 0, 0, 0, 1),
    (2, 4, 1, 1, 0, 0),
    (6, 2, 2, 0, 0, 1),
    (4, 3, 1, 0, 1, 0),
    (5, 2, 1, 1, 0, 1),
    (3, 4, 2, 0, 0, 1),
    (6, 3, 0, 1, 1, 0),
    (4, 2, 2, 1, 0, 1);
    
INSERT INTO hole14 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 3, 0, 0, 1, 2),
    (3, 2, 1, 0, 0, 1),
    (5, 4, 0, 1, 0, 0),
    (2, 1, 2, 0, 0, 2),
    (4, 3, 1, 0, 1, 1),
    (3, 2, 0, 1, 0, 2),
    (5, 4, 0, 0, 1, 0),
    (2, 1, 1, 1, 0, 3),
    (4, 3, 0, 0, 0, 1),
    (3, 2, 1, 0, 1, 2);
    
INSERT INTO hole13 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 3, 0, 0, 0, 0),
    (5, 4, 1, 0, 0, 1),
    (3, 2, 0, 0, 0, 0),
    (4, 3, 1, 0, 0, 1),
    (3, 2, 0, 1, 0, 1),
    (5, 4, 1, 1, 0, 2),
    (4, 3, 0, 1, 1, 2),
    (3, 2, 0, 0, 1, 1),
    (5, 4, 1, 0, 1, 2),
    (4, 3, 0, 0, 0, 0);
    
INSERT INTO hole15 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 3, 0, 0, 0, 0),
    (3, 4, 1, 0, 0, 1),
    (5, 2, 0, 1, 0, 0),
    (2, 5, 1, 1, 0, 2),
    (4, 3, 0, 0, 1, 0),
    (3, 4, 0, 1, 1, 1),
    (5, 2, 1, 0, 1, 1),
    (2, 5, 0, 0, 2, 2),
    (4, 3, 1, 1, 0, 1),
    (3, 4, 1, 0, 2, 2);

INSERT INTO hole16 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 3, 0, 0, 0, 0),
    (3, 2, 1, 0, 0, 1),
    (5, 4, 0, 1, 0, 0),
    (2, 1, 0, 0, 1, 0),
    (6, 5, 1, 0, 0, 0),
    (3, 2, 0, 1, 1, 0),
    (4, 3, 1, 0, 0, 1),
    (2, 1, 0, 0, 0, 2),
    (5, 4, 0, 1, 1, 0),
    (3, 2, 1, 1, 0, 1);
    
INSERT INTO hole17 (score, patts, bunker, water, ob, pena)
VALUES
    (4, 3, 0, 0, 0, 0),
    (5, 2, 1, 0, 0, 0),
    (4, 4, 0, 1, 0, 0),
    (3, 3, 0, 0, 1, 0),
    (5, 2, 1, 1, 0, 0),
    (4, 4, 1, 0, 0, 0),
    (3, 3, 0, 1, 1, 0),
    (4, 2, 1, 1, 1, 0),
    (5, 3, 2, 0, 0, 0),
    (3, 4, 1, 1, 2, 1);


INSERT INTO hole18 (score, patts, bunker, water, ob, pena)
VALUES
    (3, 2, 0, 0, 0, 1),
    (4, 1, 1, 0, 0, 0),
    (2, 3, 0, 1, 0, 1),
    (5, 1, 1, 0, 1, 0),
    (3, 2, 1, 0, 0, 1),
    (2, 4, 0, 0, 0, 0),
    (4, 2, 0, 1, 1, 0),
    (5, 1, 0, 0, 0, 2),
    (3, 3, 1, 1, 0, 1),
    (2, 2, 0, 0, 1, 1);
