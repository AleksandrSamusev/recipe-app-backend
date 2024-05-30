CREATE TABLE IF NOT EXISTS recipes
(
    recipe_id       bigint auto_increment primary key,
    author_id       BIGINT      NOT NULL REFERENCES users (user_id) ON DELETE CASCADE,
    category        ENUM ('main', 'soups', 'salads', 'desserts', 'beverages'),
    type            ENUM (
        'meat', 'seafood', 'vegetarian',
        'cakes', 'pastries', 'icecream',
        'alcohol', 'nonalcohol', 'hot'
        ),
    main_ingredient varchar(50) NOT NULL,
    title           text        NOT NULL,
    description     text        NOT NULL,
    rating          DOUBLE,
    prepare_time    TEXT        NOT NULL,
    cooking_time    TEXT        NOT NULL,
    img_large       LONGTEXT    NOT NULL,
    img_medium      LONGTEXT    NOT NULL,
    img_small_1     LONGTEXT    NOT NULL,
    img_small_2     LONGTEXT    NOT NULL,
    img_small_3     LONGTEXT    NOT NULL,
    img_small_4     LONGTEXT    NOT NULL,
    number_of_rates BIGINT,
    raw_rate        BIGINT

);

CREATE TABLE IF NOT EXISTS nutrients
(
    nutrient_id bigint auto_increment primary key,
    name        varchar(100) NOT NULL,
    value       varchar(50)  NOT NULL,
    units       varchar(50)  NOT NULL
);

CREATE TABLE IF NOT EXISTS ingredients
(
    ingredient_id bigint auto_increment primary key,
    name          varchar(100) NOT NULL,
    value         varchar(50)  NOT NULL,
    units         varchar(50)  NOT NULL
);

CREATE TABLE IF NOT EXISTS recipes_ingredients
(
    recipe_id     bigint references recipes (recipe_id),
    ingredient_id bigint references ingredients (ingredient_id),
    CONSTRAINT recipes_ingredients_pk PRIMARY KEY (recipe_id, ingredient_id)
);

CREATE TABLE IF NOT EXISTS recipes_nutrients
(
    recipe_id   bigint references recipes (recipe_id),
    nutrient_id bigint references nutrients (nutrient_id),
    CONSTRAINT recipes_nutrients_pk PRIMARY KEY (recipe_id, nutrient_id)
);

CREATE TABLE IF NOT EXISTS steps
(
    step_id     bigint auto_increment primary key,
    description text    NOT NULL,
    step_number integer NOT NULL,
    recipe_id   bigint REFERENCES recipes (recipe_id) on delete cascade
);

CREATE TABLE IF NOT EXISTS users
(
    user_id    BIGINT auto_increment primary key,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    username   VARCHAR(50) NOT NULL UNIQUE,
    password   TEXT        NOT NULL,
    email      VARCHAR(50) NOT NULL UNIQUE,
    avatar     LONGTEXT
);

CREATE TABLE IF NOT EXISTS comments
(
    comment_id BIGINT auto_increment primary key,
    comment    TEXT NOT NULL,
    author     TEXT NOT NULL,
    date       TEXT NOT NULL,
    recipe_id  bigint REFERENCES recipes (recipe_id) on delete cascade
);

CREATE TABLE IF NOT EXISTS roles
(
    role_id BIGINT auto_increment primary key,
    name    VARCHAR(50) NOT NULL CHECK (name IN ('ROLE_ADMIN', 'ROLE_USER'))
);

CREATE TABLE IF NOT EXISTS users_roles
(
    user_id BIGINT REFERENCES users (user_id),
    role_id BIGINT REFERENCES roles (role_id),
    CONSTRAINT users_roles_pk PRIMARY KEY (user_id, role_id)
);
