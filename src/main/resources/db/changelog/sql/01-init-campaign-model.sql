CREATE TABLE IF NOT EXISTS greeting
(
    id VARCHAR(50) NOT NULL,
    text VARCHAR(50) NOT NULL,
    CONSTRAINT pkey PRIMARY KEY (id)
);

INSERT INTO greeting VALUES ('hello-world', 'Hello world!');
