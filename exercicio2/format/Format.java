package exercicio2.format;

public class Format {

	public Format() {
	}
	
	public String pattern(String line) {
		line = line.replaceAll("!doctype", "");
		line = line.replaceAll("body", "");
		line = line.replaceAll("<body>", "\n<body>\n");
		line = line.replaceAll("title", "");
		line = line.replaceAll("<noscript>You need to enable JavaScript to run this app.</noscript>", "");
		line = line.replaceAll("<script", "<script\n  ");
		line = line.replaceFirst("html>", "");
		line = line.replaceAll("name = ", "name = ");
		line = line.replaceAll(">Summit", "");
		line = line.replaceAll("<", "");
		line = line.replaceAll(">", "");
		line = line.replaceAll("/html", "");
		line = line.replaceAll("/script", "");
		line = line.replaceAll("/div", "");
		line = line.replaceAll("/", "");
		line = line.replaceFirst("lang=", "\n   lang=");
		line = line.replaceFirst("head", "");
		line = line.replaceAll("meta ", "meta\n   ");
		line = line.replaceAll("\"", " ");
		line = line.replaceAll("div ", "div\n   ");
		line = line.replaceAll("link", "link\n  ");
		line = line.strip();
		return line;
	}
	
	public String withoutPattern(String line) {
		line = line.replaceAll("integrity=", "\n   integrity=");
		line = line.replaceAll("crossorigin= anonymous", "\n   crossorigin= anonymous\n");
		line = line.replaceAll("charset= utf-8", "charset= utf-8\n");
		line = line.replaceAll("maximum-scale=1", "maximum-scale=1\n");
		line = line.replaceAll("content= #222222", "content= #222222\n");
		line = line.replaceAll("content= pt-br", "content= pt-br\n");
		line = line.replaceAll("content= no", "content= no\n");
		line = line.replaceAll("content= Ivan Oliveira", "content= Ivan Oliveira\n");
		line = line.replaceAll("content= index, follow", "content= index, follow\n");
		line = line.replaceAll("content= 3 days", "content= 3 days\n");
		line = line.replaceAll("content= Summit Bra", "content= Summit Bra\n");
		line = line.replaceAll("business", "business\n");
		line = line.replaceAll("content= 320", "content= 320\n");
		line = line.replaceAll("content= True", "content= True\n");
		line = line.replaceAll("content= on", "content= on\n");
		line = line.replaceAll("capable  content= yes", "  capable  content= yes\n");
		line = line.replaceAll("content= telephone=no", "content= telephone=no\n");
		line = line.replaceAll("e-mobile-web-app.", "  e-mobile-web-app.");
		line = line.replaceAll("href= manifest.json", "href= manifest.json\n");
		line = line.replaceAll("href= favicon.ico", "href= favicon.ico\n");
		line = line.replaceAll("fullHeight", "fullHeight\n");
		return line;
	}
}
