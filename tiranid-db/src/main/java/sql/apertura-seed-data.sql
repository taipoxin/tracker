/*
work_days indexed by work_date,iterations
work_iters indexed by ddate
 */

SELECT * FROM work_days WHERE work_date = '2007-09-02';
SELECT * FROM work_days WHERE work_date => '2007-09-01' ORDER BY iterations DESC;
SELECT iterations FROM work_days WHERE work_date => '2007-09-01'
AND work_date < '2007-10-01' ORDER BY iterations DESC;

SELECT ttime FROM work_iters WHERE ddate = '2007-09-01';


INSERT INTO work_days (work_date, iterations, work_time)
	VALUES ('2007-09-02', 10, '9:13;16:18;');

INSERT INTO work_iters (ddate, ttime)
	VALUES ('2007-09-02', '04:20:00');



