DROP TABLE IF EXISTS 'books';
DROP TABLE IF EXISTS "author";

CREATE TABLE "authors"(
        "id" bigint DEFAULT nextval('authors_id_seq') NOT NULL,
        "name" text,
        "age" integer,
        CONSTRAINT "author_pkey"PRIMARY KEY ("id");

CREATE TABLE "books" (
    "isbn" text NOT NULL,
    "title" text,
    "author_id" bigint,
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn"),
    CONSTRAINT "fk_author" FOREIGN KEY (author_id)
    REFERENCES authors(id);
)


)