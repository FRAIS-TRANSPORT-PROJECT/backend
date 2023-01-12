INSERT INTO public.users
(dtype, email, first_name, last_name, matricule, "password", "role")
SELECT 'user', 'admin@mail.com', 'admin', 'admin', 'admin', '$2a$10$C4K/ga4RTloo1XyJwaDHi.pX7OYdBYEeNvF59Pbn0YrYeH.3l.qfW', 'ROLE_ADMIN'
WHERE NOT EXISTS (SELECT * FROM public.users WHERE matricule='admin');