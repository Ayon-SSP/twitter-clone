 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en" class=""><link type="text/css" id="dark-mode" rel="stylesheet" href=""><style type="text/css" id="dark-mode-custom-style"></style><style type="text/css" id="dark-mode-theme-changer-style"></style><head><link type="text/css" id="dark-mode" rel="stylesheet" href=""><style type="text/css" id="dark-mode-custom-style"></style><style type="text/css" id="dark-mode-theme-changer-style"></style>
      <meta charset="UTF-8">
      <link href="https://fonts.googleapis.com/css?family=DM+Sans&amp;display=swap" rel="stylesheet">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css">
      <script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
      <link rel="shortcut icon" href="https://abs.twimg.com/favicons/twitter.2.ico" type="image/x-icon">
      <script>
      document.title="Recommendations";
      </script>
       <link rel="stylesheet" type="text/css" href="/static/css/recommendation.css"/>

   </head>
   <body>


      <div id="root">
         <div>
            <div class="layout">
               <div class="layout_wrapper">
                  <jsp:include page="template/navbar.jsp"/>
                  <div class="layout_content">
                     <div class="feed">
                        <div class="feed_header">
                           <h1 class="feed_title">Recommendation for you:)</h1>
                        </div>

                           <c:forEach var="member" items="${RECOMMENDATIONS}">
                                <div class="feed_item">
                                     <div class="joke">
                                      <div class="joke_wrapper">
                                         <div class="joke_block joke_block--header">
                                             <span class="joke_element joke_element--author-name">${member.name}</span>
                                             <span class="joke_element joke_element--author-username">${member.email}</span>
                                            <div class="joke_element joke_element--author-img"><img src="${USER_IMAGE}"></div>
                                         </div>

                                            <c:if test="${not member.is_followed}">
                                                    <button class="follow-member" member-id=${member.id} type="submit" tabindex="0" style="margin-top:8px">
                                                                                                <span id="follow" tabindex="-1">Follow</span>
                                                    </button>
                                            </c:if>
                                            <c:if test="${member.is_followed}">
                                                    <button class="follow-member followed-button" member-id=${member.id} type="submit" tabindex="0" style="margin-top:8px">
                                                                                                <span id="follow" tabindex="-1">Followed</span>
                                                    </button>
                                            </c:if>

                                          </div>
                                       </div>
                                    </div>
                       </c:forEach>













                            <div class="feed_footer">
                           <div class="pagination pagination--infinite-scroll"><button class="pagination_button_next">Load more...</button></div>
                        </div>
                     </div>
                  </div>


                  <jsp:include page="template/sidebar.jsp" />

               </div>
            </div>
         </div>
      </div>

         <script type="text/javascript" src="/static/js/user.js" >
         </script>



      </body>
      </html>