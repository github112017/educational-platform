DELETE FROM course;
DELETE FROM teacher;

INSERT INTO teacher (username) VALUES ('teacher');
INSERT INTO course (uuid, approval_status, number, rating) VALUES ('123E4567E89B12D3A456426655440001', 'NOT_SENT_FOR_APPROVAL', 0, 0);
UPDATE course SET teacher_id = (SELECT teacher.id FROM teacher WHERE teacher.username = 'teacher' GROUP BY teacher.id);
