
/*
use database work
 */

/*
key
work_date
iterations
time
*/

CREATE TABLE IF NOT EXISTS work_days(
	id INT NOT NULL AUTO_INCREMENT,
	work_date DATE NOT NULL,
	iterations TINYINT NOT NULL,
	work_time TEXT NOT NULL,
	PRIMARY KEY(id)
);

/*
составной индекс по дате и итерациям
 */
CREATE INDEX work_date_iterations ON work_days(work_date, iterations);


/*
key
ddate
ttime
*/
CREATE TABLE IF NOT EXISTS work_iters(
	id INT NOT NULL AUTO_INCREMENT,
	ddate DATE NOT NULL,
	ttime TIME NOT NULL,
	PRIMARY KEY(id)
);

/*
индекс по дате
 */
CREATE INDEX ddate ON work_iters(ddate);