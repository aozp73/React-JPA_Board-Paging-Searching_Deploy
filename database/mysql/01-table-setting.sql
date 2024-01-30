CREATE TABLE user_tb (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(6) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL, -- UserRole 열거형을 문자열로 저장
    created_at DATETIME NOT NULL
);

CREATE TABLE board_tb (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title VARCHAR(40) NOT NULL,
    content TEXT NOT NULL,
    views INT NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_tb(id)
);

CREATE TABLE comment_tb (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    board_id BIGINT, -- board_id는 nullable이므로 NULL 허용
    content TEXT NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_tb(id),
    FOREIGN KEY (board_id) REFERENCES board_tb(id)
);
