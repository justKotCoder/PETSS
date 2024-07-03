PGDMP  8                    |            pet_passport_db    16.3    16.3 ?               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16397    pet_passport_db    DATABASE     �   CREATE DATABASE pet_passport_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE pet_passport_db;
                postgres    false            �            1259    16478 	   favorites    TABLE     �   CREATE TABLE public.favorites (
    id integer NOT NULL,
    user_id integer,
    product_id integer,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.favorites;
       public         heap    postgres    false            �            1259    16477    favorites_id_seq    SEQUENCE     �   CREATE SEQUENCE public.favorites_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.favorites_id_seq;
       public          postgres    false    226                       0    0    favorites_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.favorites_id_seq OWNED BY public.favorites.id;
          public          postgres    false    225            �            1259    16496    help_requests    TABLE       CREATE TABLE public.help_requests (
    id integer NOT NULL,
    user_id integer,
    question text NOT NULL,
    status character varying(50),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
 !   DROP TABLE public.help_requests;
       public         heap    postgres    false            �            1259    16495    help_requests_id_seq    SEQUENCE     �   CREATE SEQUENCE public.help_requests_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.help_requests_id_seq;
       public          postgres    false    228            	           0    0    help_requests_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.help_requests_id_seq OWNED BY public.help_requests.id;
          public          postgres    false    227            �            1259    16460    order_items    TABLE     �   CREATE TABLE public.order_items (
    id integer NOT NULL,
    order_id integer,
    product_id integer,
    quantity integer NOT NULL,
    price numeric(10,2) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.order_items;
       public         heap    postgres    false            �            1259    16459    order_items_id_seq    SEQUENCE     �   CREATE SEQUENCE public.order_items_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.order_items_id_seq;
       public          postgres    false    224            
           0    0    order_items_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.order_items_id_seq OWNED BY public.order_items.id;
          public          postgres    false    223            �            1259    16446    orders    TABLE     $  CREATE TABLE public.orders (
    id integer NOT NULL,
    user_id integer,
    total_amount numeric(10,2) NOT NULL,
    status character varying(50),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.orders;
       public         heap    postgres    false            �            1259    16445    orders_id_seq    SEQUENCE     �   CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.orders_id_seq;
       public          postgres    false    222                       0    0    orders_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;
          public          postgres    false    221            �            1259    16412    pets    TABLE     �  CREATE TABLE public.pets (
    id integer NOT NULL,
    user_id integer,
    name character varying(255),
    species character varying(50),
    breed character varying(255),
    age integer,
    photo_url text,
    chip_id character varying(255),
    medical_history json,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.pets;
       public         heap    postgres    false            �            1259    16411    pets_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pets_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.pets_id_seq;
       public          postgres    false    218                       0    0    pets_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.pets_id_seq OWNED BY public.pets.id;
          public          postgres    false    217            �            1259    16430    products    TABLE     f  CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    description text,
    price numeric(10,2) NOT NULL,
    category character varying(255),
    provider_id integer,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.products;
       public         heap    postgres    false            �            1259    16429    products_id_seq    SEQUENCE     �   CREATE SEQUENCE public.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.products_id_seq;
       public          postgres    false    220                       0    0    products_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;
          public          postgres    false    219            �            1259    16399    users    TABLE     q  CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(255) NOT NULL,
    password_hash text NOT NULL,
    name character varying(255),
    phone character varying(20),
    role character varying(50),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16398    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    216                       0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    215            F           2604    16481    favorites id    DEFAULT     l   ALTER TABLE ONLY public.favorites ALTER COLUMN id SET DEFAULT nextval('public.favorites_id_seq'::regclass);
 ;   ALTER TABLE public.favorites ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    226    226            H           2604    16499    help_requests id    DEFAULT     t   ALTER TABLE ONLY public.help_requests ALTER COLUMN id SET DEFAULT nextval('public.help_requests_id_seq'::regclass);
 ?   ALTER TABLE public.help_requests ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    227    228    228            D           2604    16463    order_items id    DEFAULT     p   ALTER TABLE ONLY public.order_items ALTER COLUMN id SET DEFAULT nextval('public.order_items_id_seq'::regclass);
 =   ALTER TABLE public.order_items ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    223    224    224            A           2604    16449 	   orders id    DEFAULT     f   ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);
 8   ALTER TABLE public.orders ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    221    222            ;           2604    16415    pets id    DEFAULT     b   ALTER TABLE ONLY public.pets ALTER COLUMN id SET DEFAULT nextval('public.pets_id_seq'::regclass);
 6   ALTER TABLE public.pets ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    218    218            >           2604    16433    products id    DEFAULT     j   ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);
 :   ALTER TABLE public.products ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    219    220            8           2604    16402    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215    216            �          0    16478 	   favorites 
   TABLE DATA           H   COPY public.favorites (id, user_id, product_id, created_at) FROM stdin;
    public          postgres    false    226   �J                 0    16496    help_requests 
   TABLE DATA           ^   COPY public.help_requests (id, user_id, question, status, created_at, updated_at) FROM stdin;
    public          postgres    false    228   �J       �          0    16460    order_items 
   TABLE DATA           \   COPY public.order_items (id, order_id, product_id, quantity, price, created_at) FROM stdin;
    public          postgres    false    224   K       �          0    16446    orders 
   TABLE DATA           [   COPY public.orders (id, user_id, total_amount, status, created_at, updated_at) FROM stdin;
    public          postgres    false    222   /K       �          0    16412    pets 
   TABLE DATA           �   COPY public.pets (id, user_id, name, species, breed, age, photo_url, chip_id, medical_history, created_at, updated_at) FROM stdin;
    public          postgres    false    218   LK       �          0    16430    products 
   TABLE DATA           o   COPY public.products (id, name, description, price, category, provider_id, created_at, updated_at) FROM stdin;
    public          postgres    false    220   iK       �          0    16399    users 
   TABLE DATA           d   COPY public.users (id, email, password_hash, name, phone, role, created_at, updated_at) FROM stdin;
    public          postgres    false    216   �K                  0    0    favorites_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.favorites_id_seq', 1, false);
          public          postgres    false    225                       0    0    help_requests_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.help_requests_id_seq', 1, false);
          public          postgres    false    227                       0    0    order_items_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.order_items_id_seq', 1, false);
          public          postgres    false    223                       0    0    orders_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.orders_id_seq', 1, false);
          public          postgres    false    221                       0    0    pets_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.pets_id_seq', 1, false);
          public          postgres    false    217                       0    0    products_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.products_id_seq', 1, false);
          public          postgres    false    219                       0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 1, false);
          public          postgres    false    215            Z           2606    16484    favorites favorites_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.favorites
    ADD CONSTRAINT favorites_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.favorites DROP CONSTRAINT favorites_pkey;
       public            postgres    false    226            \           2606    16505     help_requests help_requests_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.help_requests
    ADD CONSTRAINT help_requests_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.help_requests DROP CONSTRAINT help_requests_pkey;
       public            postgres    false    228            X           2606    16466    order_items order_items_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT order_items_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.order_items DROP CONSTRAINT order_items_pkey;
       public            postgres    false    224            V           2606    16453    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            postgres    false    222            P           2606    16423    pets pets_chip_id_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.pets
    ADD CONSTRAINT pets_chip_id_key UNIQUE (chip_id);
 ?   ALTER TABLE ONLY public.pets DROP CONSTRAINT pets_chip_id_key;
       public            postgres    false    218            R           2606    16421    pets pets_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.pets
    ADD CONSTRAINT pets_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.pets DROP CONSTRAINT pets_pkey;
       public            postgres    false    218            T           2606    16439    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    220            L           2606    16410    users users_email_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);
 ?   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key;
       public            postgres    false    216            N           2606    16408    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    216            b           2606    16490 #   favorites favorites_product_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.favorites
    ADD CONSTRAINT favorites_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(id);
 M   ALTER TABLE ONLY public.favorites DROP CONSTRAINT favorites_product_id_fkey;
       public          postgres    false    226    4692    220            c           2606    16485     favorites favorites_user_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.favorites
    ADD CONSTRAINT favorites_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 J   ALTER TABLE ONLY public.favorites DROP CONSTRAINT favorites_user_id_fkey;
       public          postgres    false    216    226    4686            d           2606    16506 (   help_requests help_requests_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.help_requests
    ADD CONSTRAINT help_requests_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 R   ALTER TABLE ONLY public.help_requests DROP CONSTRAINT help_requests_user_id_fkey;
       public          postgres    false    4686    228    216            `           2606    16467 %   order_items order_items_order_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT order_items_order_id_fkey FOREIGN KEY (order_id) REFERENCES public.orders(id);
 O   ALTER TABLE ONLY public.order_items DROP CONSTRAINT order_items_order_id_fkey;
       public          postgres    false    224    4694    222            a           2606    16472 '   order_items order_items_product_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT order_items_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(id);
 Q   ALTER TABLE ONLY public.order_items DROP CONSTRAINT order_items_product_id_fkey;
       public          postgres    false    224    220    4692            _           2606    16454    orders orders_user_id_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 D   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_user_id_fkey;
       public          postgres    false    222    4686    216            ]           2606    16424    pets pets_user_id_fkey    FK CONSTRAINT     u   ALTER TABLE ONLY public.pets
    ADD CONSTRAINT pets_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 @   ALTER TABLE ONLY public.pets DROP CONSTRAINT pets_user_id_fkey;
       public          postgres    false    218    4686    216            ^           2606    16440 "   products products_provider_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_provider_id_fkey FOREIGN KEY (provider_id) REFERENCES public.users(id);
 L   ALTER TABLE ONLY public.products DROP CONSTRAINT products_provider_id_fkey;
       public          postgres    false    220    216    4686            �      x������ � �            x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     