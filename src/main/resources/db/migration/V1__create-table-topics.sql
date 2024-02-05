CREATE TABLE topics
(
    id            BIGINT                 NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title         VARCHAR(255)           NOT NULL,
    message       TEXT                   NOT NULL,
    creation_date DATETIME DEFAULT NOW() NOT NULL,
    active_status BOOLEAN  DEFAULT TRUE  NOT NULL,
    author        VARCHAR(100)           NOT NULL,
    course        VARCHAR(100)           NOT NULL
);