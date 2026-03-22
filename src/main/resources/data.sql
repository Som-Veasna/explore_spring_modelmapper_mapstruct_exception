INSERT INTO addresses (street, city, country) VALUES
                                                  ('123 Main St',  'Phnom Penh', 'Cambodia'),
                                                  ('456 River Rd', 'Siem Reap',  'Cambodia'),
                                                  ('789 Lake Ave', 'Battambang', 'Cambodia'),
                                                  ('321 Hill Blvd','Kampot',     'Cambodia'),
                                                  ('654 Ocean Dr', 'Sihanouk',   'Cambodia');

INSERT INTO app_users (username, email, password, full_name, address_id) VALUES
                                                                             ('john_doe',   'john.doe@example.com',   '$2a$12$eImiTXuWVxfM37uY4JANjQ==', 'John Doe',   1),
                                                                             ('jane_smith', 'jane.smith@example.com', '$2a$12$abcXuWVxfM37uY4JANjQxx==', 'Jane Smith', 2),
                                                                             ('bob_martin', 'bob.martin@example.com', '$2a$12$xyzTXuWVxfM37uY4JANjQA==', 'Bob Martin', 3),
                                                                             ('alice_wang', 'alice.wang@example.com', '$2a$12$lmnTXuWVxfM37uY4JANjQB==', 'Alice Wang', 4),
                                                                             ('charlie_k',  'charlie.k@example.com',  '$2a$12$pqrTXuWVxfM37uY4JANjQC==', 'Charlie K',  5);