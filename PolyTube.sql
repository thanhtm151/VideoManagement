CREATE DATABASE [PolyTube]
GO
USE [PolyTube]
GO

CREATE TABLE [dbo].[FAVORITE](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[USERID] [nvarchar](10) NOT NULL,
	[VIDEO] [nvarchar](10) NOT NULL,
	[LIKEDATE] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SHARES](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[USERID] [nvarchar](10) NOT NULL,
	[VIDEO] [nvarchar](10) NOT NULL,
	[EMAIL] [nvarchar](50) NOT NULL,
	[SHAREDATE] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USERS](
	[ID] [nvarchar](10) NOT NULL,
	[PASSWORDS] [nvarchar](30) NOT NULL,
	[EMAIL] [nvarchar](50) NOT NULL,
	[FULLNAME] [nvarchar](40) NOT NULL,
	[ADMIN] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VIDEO](
	[ID] [nvarchar](10) NOT NULL,
	[TITLE] [nvarchar](50) NOT NULL,
	[POSTER] [nvarchar](50) NOT NULL,
	[VIEWS] [int] NOT NULL,
	[DISCRIPTIONS] [nvarchar](max) NULL,
	[ACTIVE] [bit] NOT NULL,
	[HREF] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[FAVORITE] ON 

INSERT [dbo].[FAVORITE] ([ID], [USERID], [VIDEO], [LIKEDATE]) VALUES (6, N'TeoNV', N'VD01', CAST(N'2023-04-10' AS Date))
INSERT [dbo].[FAVORITE] ([ID], [USERID], [VIDEO], [LIKEDATE]) VALUES (7, N'TeoNV', N'VD03', CAST(N'2023-04-10' AS Date))
INSERT [dbo].[FAVORITE] ([ID], [USERID], [VIDEO], [LIKEDATE]) VALUES (13, N'admin@123', N'VD03', CAST(N'2023-04-11' AS Date))
INSERT [dbo].[FAVORITE] ([ID], [USERID], [VIDEO], [LIKEDATE]) VALUES (15, N'TeoNV', N'VD05', CAST(N'2023-04-11' AS Date))
INSERT [dbo].[FAVORITE] ([ID], [USERID], [VIDEO], [LIKEDATE]) VALUES (16, N'KietLT', N'VD05', CAST(N'2023-04-11' AS Date))
INSERT [dbo].[FAVORITE] ([ID], [USERID], [VIDEO], [LIKEDATE]) VALUES (20, N'TeoNV', N'VD02', CAST(N'2023-04-10' AS Date))
INSERT [dbo].[FAVORITE] ([ID], [USERID], [VIDEO], [LIKEDATE]) VALUES (21, N'admin@123', N'VD02', CAST(N'2023-04-12' AS Date))
INSERT [dbo].[FAVORITE] ([ID], [USERID], [VIDEO], [LIKEDATE]) VALUES (22, N'admin@123', N'VD07', CAST(N'2023-04-12' AS Date))
INSERT [dbo].[FAVORITE] ([ID], [USERID], [VIDEO], [LIKEDATE]) VALUES (23, N'admin@123', N'VD08', CAST(N'2023-04-12' AS Date))
INSERT [dbo].[FAVORITE] ([ID], [USERID], [VIDEO], [LIKEDATE]) VALUES (30, N'admin@123', N'VD01', CAST(N'2023-04-12' AS Date))
INSERT [dbo].[FAVORITE] ([ID], [USERID], [VIDEO], [LIKEDATE]) VALUES (33, N'admin@123', N'VD09', CAST(N'2023-04-12' AS Date))
SET IDENTITY_INSERT [dbo].[FAVORITE] OFF
GO
SET IDENTITY_INSERT [dbo].[SHARES] ON 

INSERT [dbo].[SHARES] ([ID], [USERID], [VIDEO], [EMAIL], [SHAREDATE]) VALUES (1, N'TeoNV', N'VD03', N'thanhtmps25076@fpt.edu.vn', CAST(N'2023-04-11' AS Date))
INSERT [dbo].[SHARES] ([ID], [USERID], [VIDEO], [EMAIL], [SHAREDATE]) VALUES (2, N'TeoNV', N'VD03', N'thanhtmps25076@fpt.edu.vn', CAST(N'2023-04-11' AS Date))
INSERT [dbo].[SHARES] ([ID], [USERID], [VIDEO], [EMAIL], [SHAREDATE]) VALUES (3, N'admin@123', N'VD05', N'thanhtmps25076@fpt.edu.vn', CAST(N'2023-04-11' AS Date))
INSERT [dbo].[SHARES] ([ID], [USERID], [VIDEO], [EMAIL], [SHAREDATE]) VALUES (4, N'admin@123', N'VD04', N'thanhtmps25076@fpt.edu.vn', CAST(N'2023-04-11' AS Date))
INSERT [dbo].[SHARES] ([ID], [USERID], [VIDEO], [EMAIL], [SHAREDATE]) VALUES (7, N'admin@123', N'VD04', N'thanhtmps25076@fpt.edu.vn', CAST(N'2023-04-11' AS Date))
INSERT [dbo].[SHARES] ([ID], [USERID], [VIDEO], [EMAIL], [SHAREDATE]) VALUES (8, N'admin@123', N'VD04', N'thanhtmps25076@fpt.edu.vn', CAST(N'2023-04-11' AS Date))
INSERT [dbo].[SHARES] ([ID], [USERID], [VIDEO], [EMAIL], [SHAREDATE]) VALUES (9, N'admin@123', N'VD04', N'thanhtmps25076@fpt.edu.vn', CAST(N'2023-04-11' AS Date))
INSERT [dbo].[SHARES] ([ID], [USERID], [VIDEO], [EMAIL], [SHAREDATE]) VALUES (10, N'admin@123', N'VD09', N'thanhtmps25076@fpt.edu.vn', CAST(N'2023-04-11' AS Date))
SET IDENTITY_INSERT [dbo].[SHARES] OFF
GO
INSERT [dbo].[USERS] ([ID], [PASSWORDS], [EMAIL], [FULLNAME], [ADMIN]) VALUES (N'admin@123', N'123', N'ThanhMT@gmail.com', N'Trần Mạnh Thành', 1)
INSERT [dbo].[USERS] ([ID], [PASSWORDS], [EMAIL], [FULLNAME], [ADMIN]) VALUES (N'KietWibu', N'123', N'KietLT@gmail.com', N'Lại Tuấn Kiệt', 1)
INSERT [dbo].[USERS] ([ID], [PASSWORDS], [EMAIL], [FULLNAME], [ADMIN]) VALUES (N'BaoBT', N'123', N'BaoBT@gmail.com', N'Biện Thái Bảo', 0)
INSERT [dbo].[USERS] ([ID], [PASSWORDS], [EMAIL], [FULLNAME], [ADMIN]) VALUES (N'DaoNT', N'123', N'DaoNT@gmail.com', N'Nguyễn Trung Đạo', 0)
INSERT [dbo].[USERS] ([ID], [PASSWORDS], [EMAIL], [FULLNAME], [ADMIN]) VALUES (N'TeoNV', N'123', N'teonv@fpt.edu.vn', N'Nguyễn Văn Tèo', 0)
INSERT [dbo].[USERS] ([ID], [PASSWORDS], [EMAIL], [FULLNAME], [ADMIN]) VALUES (N'TruongVT', N'123', N'TruongVT@gmai.com', N'Võ Thanh Trường', 0)
GO
INSERT [dbo].[VIDEO] ([ID], [TITLE], [POSTER], [VIEWS], [DISCRIPTIONS], [ACTIVE], [HREF]) VALUES (N'VD01', N'TỪ ĐÓ - PHAN MẠNH QUỲNH |MẮT BIẾC OST', N'/templates/user/img2/VD01.jpg', 39, N'OST Mắt Biếc. Sáng tác và trình bày: Phan Mạnh Quỳnh Hoà âm,...', 1, N'HsgTIMDA6ps')
INSERT [dbo].[VIDEO] ([ID], [TITLE], [POSTER], [VIEWS], [DISCRIPTIONS], [ACTIVE], [HREF]) VALUES (N'VD02', N'Có Chàng Trai Viết Lên Cây - Phan Mạnh Quỳnh', N'/templates/user/img2/VD02.jpg', 134, N'Chính nhờ những ca từ mộc mạc, thuần khiết mà quen thuộc của ca khúc ...', 1, N'0VC6euBtKkk')
INSERT [dbo].[VIDEO] ([ID], [TITLE], [POSTER], [VIEWS], [DISCRIPTIONS], [ACTIVE], [HREF]) VALUES (N'VD03', N'HÀ LAN - PHAN MẠNH QUỲNH | MẮT BIẾC OST', N'/templates/user/img2/VD03.jpg', 45, N'Hà Lan - Phan Mạnh Quỳnh | OST Mắt Biếc.Sáng tác và ....', 1, N'xuakxSnFUxc')
INSERT [dbo].[VIDEO] ([ID], [TITLE], [POSTER], [VIEWS], [DISCRIPTIONS], [ACTIVE], [HREF]) VALUES (N'VD04', N'Pacific Rim OST Soundtrack - 01 - MAIN THEME ', N'/templates/user/img2/VD04.jpg', 104, N'This is the Main Theme of Pacific Rim !', 1, N'1vU7XqToZso')
INSERT [dbo].[VIDEO] ([ID], [TITLE], [POSTER], [VIEWS], [DISCRIPTIONS], [ACTIVE], [HREF]) VALUES (N'VD05', N'Lạc Vào Em - Cảm Ơn Em Đã Đến Bên Anh ', N'/templates/user/img2/VD05.jpg', 32, N'Lạc Vào Em - Cảm Ơn Em Đã Đến Bên Anh - May Mắn Khi Có Em | .....', 1, N'2xG4GFrM1Mk')
INSERT [dbo].[VIDEO] ([ID], [TITLE], [POSTER], [VIEWS], [DISCRIPTIONS], [ACTIVE], [HREF]) VALUES (N'VD06', N'MẮT BIẾC OST FULL | TUYỂN TẬP NHẠC PHIM MẮT BIẾC', N'/templates/user/img2/VD06.jpg', 3, N'MẮT BIẾC OST FULL | TUYỂN TẬP NHẠC PHIM MẮT BIẾC ', 1, N'H2hgT5VDkCc')
INSERT [dbo].[VIDEO] ([ID], [TITLE], [POSTER], [VIEWS], [DISCRIPTIONS], [ACTIVE], [HREF]) VALUES (N'VD07', N'SAO CHA KHÔNG - PHAN MẠNH QUỲNH | OFFICIAL MV |', N'/templates/user/img2/VD07.jpg', 13, N'SAO CHA KHÔNG - PHAN MẠNH QUỲNH | OFFICIAL MV |', 1, N'TD7sBUigDIU')
INSERT [dbo].[VIDEO] ([ID], [TITLE], [POSTER], [VIEWS], [DISCRIPTIONS], [ACTIVE], [HREF]) VALUES (N'VD08', N'LỚN RỒI CÒN KHÓC NHÈ ( MV ) | TRÚC NHÂN', N'/templates/user/img2/VD08.jpg', 12, N'LỚN RỒI CÒN KHÓC NHÈ ( MV ) | TRÚC NHÂN', 1, N'pFSQh_5QE40')
INSERT [dbo].[VIDEO] ([ID], [TITLE], [POSTER], [VIEWS], [DISCRIPTIONS], [ACTIVE], [HREF]) VALUES (N'VD09', N'Spring Boot Tutorial for Beginners(Java Framework)', N'/templates/user/img2/VD09.jpg', 27, N'Learn Spring Boot in this full course for beginners. Spring Boot is an amazing .....', 1, N'vtPkZShrvXQ')
INSERT [dbo].[VIDEO] ([ID], [TITLE], [POSTER], [VIEWS], [DISCRIPTIONS], [ACTIVE], [HREF]) VALUES (N'VD10', N'[Vietsub l Hán Việt] Giang Hồ Tiếu - Châu Hoa Kiện', N'/templates/user/img2/VD10.jpg', 2, N'Bản Nhạc Cổ Điển Trung Quốc Bất Hủ Hay Nhất .....', 1, N'JvB6N7loN80')
GO
