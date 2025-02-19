-- Create about table
CREATE TABLE about
(
    id         BIGSERIAL PRIMARY KEY,
    bio        TEXT NOT NULL,
    avatar_url VARCHAR(255),
    resume_url VARCHAR(255)
);

-- Create education table
CREATE TABLE education
(
    id             BIGSERIAL PRIMARY KEY,
    institution    VARCHAR(255) NOT NULL,
    field_of_study VARCHAR(255) NOT NULL,
    description    TEXT         NOT NULL,
    start_date     DATE         NOT NULL,
    end_date       DATE,
    about_id       BIGINT       NOT NULL REFERENCES about (id)
);

-- Create experience table
CREATE TABLE experience
(
    id          BIGSERIAL PRIMARY KEY,
    company     VARCHAR(255),
    role        VARCHAR(255),
    start_date  DATE,
    end_date    DATE,
    description VARCHAR(255),
    about_id    BIGINT NOT NULL REFERENCES about (id)
);

-- Create social_links table for element collection
CREATE TABLE social_links
(
    about_id BIGINT       NOT NULL REFERENCES about (id),
    platform VARCHAR(255) NOT NULL,
    url      VARCHAR(255) NOT NULL,
    PRIMARY KEY (about_id, platform)
);

-- Create project table
CREATE TABLE project
(
    id                BIGSERIAL PRIMARY KEY,
    title             VARCHAR(255) NOT NULL,
    slug              VARCHAR(255) NOT NULL UNIQUE,
    description       TEXT         NOT NULL,
    short_description VARCHAR(255),
    github_url        VARCHAR(255) NOT NULL,
    demo_url          VARCHAR(255),
    start_date        DATE         NOT NULL,
    is_featured       BOOLEAN      NOT NULL DEFAULT FALSE
);

-- Create technology table
CREATE TABLE technology
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL UNIQUE,
    icon_url VARCHAR(255)
);

-- Create media table
CREATE TABLE media
(
    id         BIGSERIAL PRIMARY KEY,
    url        VARCHAR(255) NOT NULL,
    media_type VARCHAR(50)  NOT NULL CHECK (media_type IN ('IMAGE', 'VIDEO', 'GIF')),
    project_id BIGINT       NOT NULL REFERENCES project (id)
);

-- Create project_technology join table
CREATE TABLE project_technology
(
    project_id    BIGINT NOT NULL REFERENCES project (id),
    technology_id BIGINT NOT NULL REFERENCES technology (id),
    PRIMARY KEY (project_id, technology_id)
);