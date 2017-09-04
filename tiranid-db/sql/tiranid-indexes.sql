/* should be executed once */
/*
    составной индекс по дате и итерациям
*/
ALTER TABLE work_days ADD INDEX work_date_iterations(work_date, iterations);

/*
      индекс по дате
*/
ALTER TABLE work_iters ADD INDEX ddate(ddate);
