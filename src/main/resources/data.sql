INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Football match between Team A and Team B', '2024-12-20', '18:30:00', 'Team A', 'Team B', 'FOOTBALL'),
    ('Basketball match between Team C and Team D', '2024-12-21', '20:00:00', 'Team C', 'Team D', 'BASKETBALL'),
    ('Tennis match between Player X and Player Y', '2024-12-22', '14:00:00', 'Player X', 'Player Y', 'BASKETBALL'),
    ('Cricket match between Team E and Team F', '2024-12-23', '16:30:00', 'Team E', 'Team F', 'BASKETBALL');

INSERT INTO match_odd (match_id, specifier, odd)
VALUES
    (1, 'Win Team A', 1.8),
    (1, 'Draw', 3.2),
    (1, 'Win Team B', 2.1),
    (1, 'Over 2.5 goals', 2.5),
    (1, 'Under 2.5 goals', 1.6),
    (1, 'X', 3.2);

INSERT INTO match_odd (match_id, specifier, odd)
VALUES
    (2, 'Win Team C', 1.9),
    (2, 'Draw', 3.5),
    (2, 'Win Team D', 2.0),
    (2, 'Over 210.5 points', 2.2),
    (2, 'Under 210.5 points', 1.7),
    (2, 'X', 3.5);

INSERT INTO match_odd (match_id, specifier, odd)
VALUES
    (3, 'Win Player X', 1.6),
    (3, 'Win Player Y', 2.4),
    (3, 'Over 3 sets', 2.0),
    (3, 'Under 3 sets', 1.7),
    (3, 'X', 3.0);

INSERT INTO match_odd (match_id, specifier, odd)
VALUES
    (4, 'Win Team E', 1.5),
    (4, 'Win Team F', 2.3),
    (4, 'Over 300 runs', 2.1),
    (4, 'Under 300 runs', 1.8),
    (4, 'X', 3.4);
