-- Using import.sql for automatic data import via Hibernate
-- Insert default users
INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('bart', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

-- Insert default authorities
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('bart', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('bart', 'ROLE_ADMIN');

-- Insert default crew
INSERT INTO crew (id, crew_name) VALUES (1, 'Zware acht');
INSERT INTO crew (id, crew_name) VALUES (2, 'Licht acht');
INSERT INTO crew (id, crew_name) VALUES (3, 'Dames acht');

-- Insert default rowers
INSERT INTO person (dtype, first_name, last_name, gender, is_rower, number_of_victory_points, date_of_birth) VALUES ('Rower', 'Bart', 'Vriesema', 'male', TRUE, 0, '1978-05-07');
INSERT INTO person (dtype, first_name, last_name, gender, is_rower, number_of_victory_points, date_of_birth) VALUES ('Rower', 'Inge', 'van Putten', 'female', TRUE, 0, '1975-01-06');
INSERT INTO person (dtype, first_name, last_name, gender, is_rower, number_of_victory_points, date_of_birth, crew_id) VALUES ('Rower', 'Melvin', 'Twellaar', 'male', TRUE, 7, '1996-12-23', 1);
INSERT INTO person (dtype, first_name, last_name, gender, is_rower, number_of_victory_points, date_of_birth, crew_id) VALUES ('Rower', 'Stef', 'Broenink', 'male', TRUE, 12, '1980-09-19', 1);
INSERT INTO person (dtype, first_name, last_name, gender, is_rower, number_of_victory_points, date_of_birth, crew_id) VALUES ('Rower', 'Ilse', 'Paulis', 'female', TRUE, 13, '1993-07-30', 3);
INSERT INTO person (dtype, first_name, last_name, gender, is_rower, number_of_victory_points, date_of_birth, crew_id) VALUES ('Rower', 'Marieke', 'Keijser', 'female', TRUE, 6, '1997-01-21', 3);

-- Insert default training types
INSERT INTO training_type (id, short_description, lower_heart_rate, upper_heart_rate) VALUES (1, 'ED', 90, 120);
INSERT INTO training_type (id, short_description, lower_heart_rate, upper_heart_rate) VALUES (2, 'AT', 120, 150);
INSERT INTO training_type (id, short_description, lower_heart_rate, upper_heart_rate) VALUES (3, 'ID', 150, 180);

-- Insert default training schedules
INSERT INTO training_schedule (id, crew_id) VALUES (1, 1);
INSERT INTO training_schedule (id, crew_id) VALUES (2, 2);
INSERT INTO training_schedule (id, crew_id) VALUES (3, 3);

-- Insert default training session
INSERT INTO training_session (id, start_time, end_time, short_description, long_description, training_schedule_id, training_type_id) VALUES (1, '2021-07-01 12:00', '2021-07-01 14:00', 'Korte tekst', 'Veel langere tekst', 1, 1);
INSERT INTO training_session (id, start_time, end_time, short_description, long_description, training_schedule_id, training_type_id) VALUES (2, '2021-07-01 12:00', '2021-07-01 14:00', 'Korte tekst', 'Veel langere tekst', 1, 2);
INSERT INTO training_session (id, start_time, end_time, short_description, long_description, training_schedule_id, training_type_id) VALUES (3, '2021-07-01 12:00', '2021-07-01 14:00', 'Korte tekst', 'Veel langere tekst', 1, 3);
INSERT INTO training_session (id, start_time, end_time, short_description, long_description, training_schedule_id, training_type_id) VALUES (4, '2021-07-01 12:00', '2021-07-01 14:00', 'Korte tekst', 'Veel langere tekst', 2, 1);
INSERT INTO training_session (id, start_time, end_time, short_description, long_description, training_schedule_id, training_type_id) VALUES (5, '2021-07-01 12:00', '2021-07-01 14:00', 'Korte tekst', 'Veel langere tekst', 2, 2);
INSERT INTO training_session (id, start_time, end_time, short_description, long_description, training_schedule_id, training_type_id) VALUES (6, '2021-07-01 12:00', '2021-07-01 14:00', 'Korte tekst', 'Veel langere tekst', 2, 3);
INSERT INTO training_session (id, start_time, end_time, short_description, long_description, training_schedule_id, training_type_id) VALUES (7, '2021-07-01 12:00', '2021-07-01 14:00', 'Korte tekst', 'Veel langere tekst', 3, 1);
INSERT INTO training_session (id, start_time, end_time, short_description, long_description, training_schedule_id, training_type_id) VALUES (8, '2021-07-01 12:00', '2021-07-01 14:00', 'Korte tekst', 'Veel langere tekst', 3, 2);
INSERT INTO training_session (id, start_time, end_time, short_description, long_description, training_schedule_id, training_type_id) VALUES (9, '2021-07-01 12:00', '2021-07-01 14:00', 'Korte tekst', 'Veel langere tekst', 3, 3);



