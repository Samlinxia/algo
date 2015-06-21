/**
 * Method 1: uncorrelated subquery
 */
select MAX(Salary)
from Employee as e
where e.Salary < (select MAX(Salary)
                    from Employee )


/**
 * Method 2: correlated subquery
 */

select Salary
from Employee as e1
where (1) = ( select count(distinct(Salary))
              from Employee as e2
              where e2.Salary > e1.Salary)

/**
 * Method 3: correlated subquery
 */

select Salary
from Employee as e1
ORDER BY Salary DESC
limit 1, 1 "1st arg offset from 1st row; 2nd arg max row return
