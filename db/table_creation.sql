CREATE TABLE empV3  (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    department VARCHAR(20) NOT NULL CHECK (department IN ('HR', 'Engineering', 'Sales', 'Marketing', 'Finance')),
    position VARCHAR(10) NOT NULL CHECK (position IN ('Manager', 'Senior', 'Junior', 'Intern')),
    phone VARCHAR(15)
);