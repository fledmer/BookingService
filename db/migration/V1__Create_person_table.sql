CREATE TABLE IF NOT EXISTS car(
    id serial,
    brand text,
    model text,
    booked boolean,
    booking_start_time timestamptz
);

select * from car