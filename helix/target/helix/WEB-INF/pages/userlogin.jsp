<html>
<body>

    USER is trying to login at
    <br>
    </br>
    <div id="time" >
    </div>
    <br>
    </br>

    <div>
        <marquee> Made with love by Mohit kota   </marquee>
    </div>
    <script type="text/javascript">

        function updateTime(){
            document.getElementById("time").innerText=new Date().toString();
        }

        setInterval(updateTime , 1000 );
    </script>
</body>
</html>