ALTER TABLE passenger_review
ADD COLUMN passenger_id BIGINT NOT NULL,
ADD FOREIGN KEY (passenger_id) REFERENCES passenger(id) ON DELETE CASCADE;
