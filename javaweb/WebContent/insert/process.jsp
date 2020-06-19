<%@page import="java.io.*"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.Date" %>

    <%	
    	//파라미터 인코딩 설정
    	//post방식으로 전송된 경우 encoding은 필수이다
    	request.setCharacterEncoding("utf-8");
    
    	//1.파라미터 읽기
    	String member_email = request.getParameter("member_email");
    	String member_password = request.getParameter("member_password");
    	String member_name = request.getParameter("member_name");
    	
    	System.out.println(member_email+member_password+member_name);
    	
    	//2.businexx logic을 수행하고 결과를 생성
    	boolean result = true;
    	
    	//오늘 날짜를 문자열로 만들기
    	Calendar calendar = new GregorianCalendar(); //객체지향 -> 추상화된 클래스,인터페이스를 Calendar 에 모아둬서 그 중에 GregorianCalendar 를 가져온다는 것
    	Date today = new Date(calendar.getTimeInMillis());
    	String filename = today.toString();
    	
    	//insert의 절대 경로 가져오기
    	//절대 경로 : 절대 경로는 프로젝트 밖에 있는걸 가져오기가 편해서 좋다 하지만 프로젝트를 옮길 경우 주소를 바꿔줘야 한다. 
    	//상대경로 : 상대 경로의 장점은 프로젝트 안에 있어서 프로젝트를 옮겨도 주소를 바꿀 필요가 없다 하지만 프로젝트안에서 만들어지기 때문에 프로젝트가 무거워 진다.
    	String filepath = application.getRealPath("/insert");
    	String logfile = filepath + "/" + filename+ ".txt";
    	
    	//현재 프로젝트의 insert 디렉토리에 오늘날짜.txt
    	//파일에 email,password,name을 기록
    	PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(logfile,true)));
    	
    	//파일에 기록
    	pw.println(member_email + " : "+ member_password+ " : "+ member_name + " : "+request.getRemoteAddr()+"\n");
    	
    	//버퍼를 비우고 스트림 닫기
    	pw.flush();
    	pw.close();
    	//3.결과를 저장하고 결과 페이지로 이동
    	//request.setAttribute("result", result);
    	//redirect를 할 경우 session이나 application을 활용하여 저장해야 한다.
    	session.setAttribute("result", result);
    	
    	//포워딩 하기
     	/*RequestDispatcher requestDispatcher = request.getRequestDispatcher("output.jsp");
    	requestDispatcher.forward(request, response); */
    	
    	response.sendRedirect("output.jsp");
    	
    	
    %>