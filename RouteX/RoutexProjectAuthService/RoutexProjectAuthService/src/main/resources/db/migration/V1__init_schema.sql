-- Create tables without foreign keys first (driver and passenger have no direct dependencies)
CREATE TABLE driver (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,           -- From Basemodel
    created_at TIMESTAMP NOT NULL,                  -- From Basemodel, @CreatedDate
    updated_at TIMESTAMP NOT NULL,                  -- From Basemodel, @LastModifiedDate
    dname VARCHAR(255),                             -- Driver field
    dlicences_number VARCHAR(255) NOT NULL UNIQUE   -- Driver field, unique constraint
);

CREATE TABLE passenger (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,           -- From Basemodel
    created_at TIMESTAMP NOT NULL,                  -- From Basemodel
    updated_at TIMESTAMP NOT NULL,                  -- From Basemodel
    name VARCHAR(255)                               -- Passenger field
);

-- Create review table (references booking, but we’ll add the FK later)
CREATE TABLE booking_review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,           -- From Basemodel
    created_at TIMESTAMP NOT NULL,                  -- From Basemodel
    updated_at TIMESTAMP NOT NULL,                  -- From Basemodel
    content VARCHAR(255) NOT NULL,                  -- Review field
    rating DOUBLE,                                  -- Review field
    booking_id BIGINT UNIQUE                        -- Foreign key for Booking (1:1), added later
);

-- Create booking table (references driver, passenger, and review)
CREATE TABLE booking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,           -- From Basemodel
    created_at TIMESTAMP NOT NULL,                  -- From Basemodel
    updated_at TIMESTAMP NOT NULL,                  -- From Basemodel
    review_id BIGINT UNIQUE,                        -- Foreign key for Review (1:1)
    booking_status VARCHAR(50) NOT NULL,            -- Enum as STRING (Scheduled, Canceled, etc.)
    start_time TIMESTAMP,                           -- Booking field
    end_time TIMESTAMP,                             -- Booking field
    tot_distance BIGINT,                            -- Booking field
    driver_id BIGINT,                               -- Foreign key for Driver (ManyToOne)
    passenger_id BIGINT,                             -- Foreign key for Passenger (ManyToOne),
    FOREIGN KEY (driver_id) REFERENCES driver(id),
    FOREIGN KEY (passenger_id) REFERENCES passenger(id)
);

CREATE TABLE passenger_review (
  id     BIGINT  NOT NULL,
    passenger_review_content VARCHAR(255) NOT NULL,
    passenger_rating VARCHAR(10) NOT NULL
);

-- Add foreign key to booking_review (1:1 with booking)
ALTER TABLE booking_review
    ADD FOREIGN KEY (booking_id) REFERENCES booking(id);

-- Add foreign key to booking for booking_review (1:1 with cascade)
ALTER TABLE booking
    ADD FOREIGN KEY (review_id) REFERENCES booking_review(id) ON DELETE CASCADE;
