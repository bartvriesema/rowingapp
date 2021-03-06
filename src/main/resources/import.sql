-- Using import.sql for automatic data import via Hibernate
-- Insert default users
INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$05$M5BRDXeU2GkGhCgOBqiDz.zrBGX5VljcxyYnPVhh.uGoha/7kcJU6', TRUE); -- password: password
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$05$XBOpcjJIA9jN7ZTLzqp2xeGz1g3Ju/phDHkVPH6LH97F0TftOgSBC', TRUE); -- password: password
INSERT INTO users (username, password, enabled) VALUES ('roeier', '$2a$05$s89KzWi1HbstnsDFCY28kOQcbsHKQ2.qIz2Tq154h59tSrsvbSsQu', TRUE); -- password: roeier
INSERT INTO users (username, password, enabled) VALUES ('coach', '$2a$05$UeHOX6eOyzSiqTfv3weZXOoGQtMtQIJO62waJKaSloFlrZGv0Bc72', TRUE); -- password: coach

-- Insert default authorities
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('bart', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('bart', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('roeier', 'ROLE_ROWER');
INSERT INTO authorities (username, authority) VALUES ('coach', 'ROLE_COACH');

-- Insert default crew
INSERT INTO crew (crew_name) VALUES ('Zware acht');
INSERT INTO crew (crew_name) VALUES ('Licht acht');
INSERT INTO crew (crew_name) VALUES ('Dames acht');

-- Insert default training types
INSERT INTO training_type (short_description, lower_heart_rate, upper_heart_rate) VALUES ('ED', 90, 120);
INSERT INTO training_type (short_description, lower_heart_rate, upper_heart_rate) VALUES ('AT', 120, 150);
INSERT INTO training_type (short_description, lower_heart_rate, upper_heart_rate) VALUES ('ID', 150, 180);

-- Insert default training schedules
INSERT INTO training_schedule (crew_id) VALUES (1);
INSERT INTO training_schedule (crew_id) VALUES (2);
INSERT INTO training_schedule (crew_id) VALUES (3);

-- Insert default persons
INSERT INTO person (dtype, first_name, last_name, gender, crew_coach, club_coach, date_of_birth, crew_id) VALUES ('Coach', 'Bart', 'Vriesema', 'male', TRUE, TRUE, '1978-05-07', 1);
INSERT INTO person (dtype, first_name, last_name, gender, crew_coach, club_coach, date_of_birth, crew_id) VALUES ('Coach', 'Inge', 'van Putten', 'female', TRUE, FALSE, '1975-01-06', 2);
INSERT INTO person (dtype, first_name, last_name, gender, is_rower, number_of_victory_points, date_of_birth, crew_id) VALUES ('Rower', 'Melvin', 'Twellaar', 'male', TRUE, 7, '1996-12-23', 1);
INSERT INTO person (dtype, first_name, last_name, gender, is_rower, number_of_victory_points, date_of_birth, crew_id) VALUES ('Rower', 'Stef', 'Broenink', 'male', TRUE, 12, '1980-09-19', 1);
INSERT INTO person (dtype, first_name, last_name, gender, is_rower, number_of_victory_points, date_of_birth, crew_id) VALUES ('Rower', 'Ilse', 'Paulis', 'female', TRUE, 13, '1993-07-30', 3);
INSERT INTO person (dtype, first_name, last_name, gender, is_rower, number_of_victory_points, date_of_birth, crew_id) VALUES ('Rower', 'Marieke', 'Keijser', 'female', TRUE, 6, '1997-01-21', 3);

-- Insert default training session
INSERT INTO training_session (start_time, end_time, short_description, long_description, training_schedule_training_schedule_id, training_type_training_type_id) VALUES ('2021-07-01 12:00', '2021-07-01 14:00', 'Korte tekst', 'Veel langere tekst', 1, 1);
INSERT INTO training_session (start_time, end_time, short_description, long_description, training_schedule_training_schedule_id, training_type_training_type_id) VALUES ('2021-07-02 12:00', '2021-07-02 14:00', 'Korte tekst', 'Veel langere tekst', 1, 2);
INSERT INTO training_session (start_time, end_time, short_description, long_description, training_schedule_training_schedule_id, training_type_training_type_id) VALUES ('2021-07-03 12:00', '2021-07-03 14:00', 'Korte tekst', 'Veel langere tekst', 1, 3);
INSERT INTO training_session (start_time, end_time, short_description, long_description, training_schedule_training_schedule_id, training_type_training_type_id) VALUES ('2021-07-04 12:00', '2021-07-04 14:00', 'Korte tekst', 'Veel langere tekst', 2, 1);
INSERT INTO training_session (start_time, end_time, short_description, long_description, training_schedule_training_schedule_id, training_type_training_type_id) VALUES ('2021-07-05 12:00', '2021-07-05 14:00', 'Korte tekst', 'Veel langere tekst', 2, 2);
INSERT INTO training_session (start_time, end_time, short_description, long_description, training_schedule_training_schedule_id, training_type_training_type_id) VALUES ('2021-07-06 12:00', '2021-07-06 14:00', 'Korte tekst', 'Veel langere tekst', 2, 3);
INSERT INTO training_session (start_time, end_time, short_description, long_description, training_schedule_training_schedule_id, training_type_training_type_id) VALUES ('2021-07-07 12:00', '2021-07-07 14:00', 'Korte tekst', 'Veel langere tekst', 3, 1);
INSERT INTO training_session (start_time, end_time, short_description, long_description, training_schedule_training_schedule_id, training_type_training_type_id) VALUES ('2021-07-08 12:00', '2021-07-08 14:00', 'Korte tekst', 'Veel langere tekst', 3, 2);
INSERT INTO training_session (start_time, end_time, short_description, long_description, training_schedule_training_schedule_id, training_type_training_type_id) VALUES ('2021-07-09 12:00', '2021-07-09 14:00', 'Korte tekst', 'Veel langere tekst', 3, 3);

-- Insert heart rates
INSERT INTO heart_rate (heart_rate, heart_rate_date, rower_person_id) VALUES (60, '2021-07-20', 3);
INSERT INTO heart_rate (heart_rate, heart_rate_date, rower_person_id) VALUES (63, '2021-07-21', 3);
INSERT INTO heart_rate (heart_rate, heart_rate_date, rower_person_id) VALUES (60, '2021-07-22', 3);
INSERT INTO heart_rate (heart_rate, heart_rate_date, rower_person_id) VALUES (62, '2021-07-23', 3);
INSERT INTO heart_rate (heart_rate, heart_rate_date, rower_person_id) VALUES (61, '2021-07-24', 3);

-- Insert results
INSERT INTO result (description, distance, result_date, time_in_seconds, crew_id) VALUES ('Winterwedstrijd', 5000, '2021-02-02', 1800, 1);
INSERT INTO result (description, distance, result_date, time_in_seconds, crew_id) VALUES ('Holland Beker', 2000, '2021-05-07', 420, 2);

-- Insert training report
INSERT INTO training_report (training_report_text, training_session_training_session_id) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 1);