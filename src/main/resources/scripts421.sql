ALTER TABLE students ALTER COLUMN age CHECK (age > 15);
ALTER TABLE students ALTER COLUMN name SET NOT NULL;
ALTER TABLE students ADD CONSTRAINT name_unique UNIQUE (name);
ALTER TABLE faculties ADD CONSTRAINT name_color_unique UNIQUE (name, color);
ALTER TABLE students ADD CONSTRAINT age_default DEFAULT 20 FOR age;

