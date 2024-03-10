INSERT INTO user_groups (name) VALUES ('admin');
INSERT INTO users (name, username,
                             user_password,
                             email, group_id)
VALUES ('Mhusika Nguli', 'mhusika',
        '$2a$10$EJ5rqiOhTKpNt06OHrnyd.yamnNdzVzWnm4icobyLOtgFAsh9Wmia',
        'mhusika@me.com', '1');