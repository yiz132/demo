curl localhost:8080/user/register -d email=user_normal_1@o.com -d password=123456 -d longitude=36.09024 -d latitude=-95.712891 -d age=10 -d name=normal_1

curl localhost:8080/user/register -d email=user_normal_2@o.com -d password=123456 -d longitude=38.09024 -d latitude=-95.712891 -d age=20 -d name=normal_2

curl localhost:8080/user/register -d email=suspected_1@o.com -d password=123456 -d longitude=36.29024 -d latitude=-95.712891 name=suspected_1 -d age=20 

curl localhost:8080/user/register -d email=suspected_2@o.com -d password=123456 -d longitude=36.19024 -d latitude=-95.712891 -d name=suspected_2 -d age=50

curl localhost:8080/user/register -d email=suspected_3@o.com -d password=123456 -d longitude=36.79024 -d latitude=-95.712891 -d name=suspected_3 -d age=29

curl localhost:8080/user/register -d email=suspected_4@o.com -d password=123456 -d longitude=36.09024 -d latitude=-95.812891 -d name=suspected_4 -d age=35

curl localhost:8080/user/register -d email=confirmed_1@o.com -d password=123456 -d longitude=36.19024 -d latitude=-95.912891 -d name=confirmed_1 -d age=60

curl localhost:8080/user/register -d email=confirmed_2@o.com -d password=123456 -d longitude=36.09024 -d latitude=-95.112891 -d name=confirmed_2 -d age=24

curl localhost:8080/user/register -d email=confirmed_3@o.com -d password=123456 -d longitude=36.59024 -d latitude=-95.212891 -d name=confirmed_3 -d age=37

curl localhost:8080/user/register -d email=confirmed_4@o.com -d password=123456 -d longitude=36.39024 -d latitude=-95.312891 -d name=confirmed_4 -d age=13