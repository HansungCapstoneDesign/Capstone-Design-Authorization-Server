INSERT INTO
    `clients` (`id`, `client_id`, `secret`, `scope`, `auth_method`, `grant_type`, `redirect_uri`)
VALUES
    ('1', 'client', 'secret', 'openid', 'client_secret_basic', 'authorization_code', 'http://localhost:8070/authorized');

INSERT INTO `users`
    (`id`, `username`, `password`, `authority`, `student_id`, `first_track`, `second_track`, `picture`)
VALUES
    ('1', '오찬근', '1234', 'read', '1891239', '모바일소프트웨어트랙', '웹공학트랙', 'http://localhost:8081/profile_image/picture.jpg'),
    ('2', '권현택', '1234', 'read', '1871308', '모바일소프트웨어트랙', '웹공학트랙', 'http://localhost:8081/profile_image/picture.jpg'),
    ('3', '곽은서', '1234', 'read', '1971096', '모바일소프트웨어트랙', '웹공학트랙', 'http://localhost:8081/profile_image/picture.jpg'),
    ('4', '김서영', '1234', 'read', '2071274', '모바일소프트웨어트랙', '웹공학트랙', 'http://localhost:8081/profile_image/picture.jpg');
