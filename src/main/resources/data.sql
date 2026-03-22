INSERT INTO app_users (username, email, password, full_name) VALUES
                                                                 ('john_doe',    'john.doe@example.com',    '$2a$12$eImiTXuWVxfM37uY4JANjQ==', 'John Doe'),
                                                                 ('jane_smith',  'jane.smith@example.com',  '$2a$12$abcXuWVxfM37uY4JANjQxx==', 'Jane Smith'),
                                                                 ('bob_martin',  'bob.martin@example.com',  '$2a$12$xyzTXuWVxfM37uY4JANjQA==', 'Bob Martin'),
                                                                 ('alice_wang',  'alice.wang@example.com',  '$2a$12$lmnTXuWVxfM37uY4JANjQB==', 'Alice Wang'),
                                                                 ('charlie_k',   'charlie.k@example.com',   '$2a$12$pqrTXuWVxfM37uY4JANjQC==', NULL);

-- Verify inserted records
SELECT * FROM app_users;