package com.fsnip.platform.global;

public class Page {
	
	public String orderQueryString = "";
	public String queryString = "";
	public String pageBar = "";
	
	public String getOrderQueryString() {
		return orderQueryString;
	}
	public void setOrderQueryString(String orderQueryString) {
		this.orderQueryString = orderQueryString;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public String getPageBar() {
		return pageBar;
	}
	public void setPageBar(String pageBar) {
		this.pageBar = pageBar;
	}

	public void getUrl(int num, int page, int pageSize, String queryString) {
		if(num == 0){
			this.setPageBar("暂时没有记录!");
			return;
		}
		double pages = Math.ceil(((float)num / (float)pageSize));

		StringBuffer sbUrl = new StringBuffer();
		sbUrl.append("<span style=\"white-space:nowrap;\">");
		String aCss = " style=\"TEXT-DECORATION:none\"";
		String first = "<a " + aCss + "  href=\"?" + queryString + "&page=0\" class='prev'>首页</a>";;
		String last = "<a " + aCss + "  href=\"?" + queryString + "&page=" + (int)(pages - 1)
		+ "\" class='prev'>尾页</a>";;
		String pre = "";
		String next = "";
		String icon_pre = "上一页";
		String icon_next = "下一页";
		
		if (page <= 0) {
			pre = icon_pre;
			if (page < pages - 1) {
				next = "<a " + aCss + " href=\"?" + queryString + "&page=" + (page + 1)
						+ "\" class='prev'>" + icon_next + "</a>";
			} else {
				next = icon_next;
			}

		} else if (page >= pages - 1) {
			pre = "<a " + aCss + "  href=\"?page=" + (page - 1) + "" + queryString + "\" class='prev'>"
					+ icon_pre + "</a>";
			next = icon_next;
		} else {
			pre = "<a " + aCss + "  href=\"?page=" + (page - 1) + "" + queryString + "\" class='prev'>"
					+ icon_pre + "</a>";

			next = "<a " + aCss + "  href=\"?&page=" + (page + 1) + "" + queryString + "\" class='prev'>"
					+ icon_next + "</a>";
		}
		sbUrl.append("&nbsp;" + first);
		sbUrl.append("&nbsp;" + pre);
		sbUrl.append("&nbsp;" + next);
		sbUrl.append("&nbsp;" + last);
		sbUrl.append("&nbsp;&nbsp;第" +(page+1)+ "页    " + " / 共" + (int)pages + "页" + "&nbsp;共" + num + "记录");
		
		sbUrl.append("&nbsp;&nbsp;<input id=\"page_num\" type=\"text\" style=\"width:40px;white-space:nowrap;display:inline-block;\" onkeydown=\"var e=this.event||window.event;var code=parseInt(e.keyCode);if(code>=96&&code<=105||code>=48&&code<=57||code==8){return true;}else{return false;} \"/>");
		sbUrl.append("&nbsp;<a href=\"javascript:void(0)\"  onClick=\"go_page();\" class='prev'>跳转</a>");
		sbUrl.append("</span>");
		
		sbUrl.append("<script>");
		sbUrl.append("function go_page(){");
		sbUrl.append("var count = " + pages + ";");
		sbUrl.append("var page_num=document.getElementById('page_num').value;");
		sbUrl.append("if(page_num=='' || page_num==null){");
		sbUrl.append("alert('请输入正确的页码！');return false;");
		sbUrl.append("}");
		sbUrl.append("var nubmer = parseInt(page_num);");
		sbUrl.append("if(isNaN(nubmer)||nubmer<=0||!(/^\\d+$/.test(nubmer))){");
		sbUrl.append("alert('请输入正确的页码！');return false;");
		sbUrl.append("}");
		
		sbUrl.append("if(page_num > count){");
		sbUrl.append("alert('当前最大页数为" + (int)pages + "，请输入正确的页码！');return false;");
		sbUrl.append("}");
		
		sbUrl.append("window.location.href='?page='+(nubmer-1)+'" + queryString + "';");
		sbUrl.append("");
		sbUrl.append("}");
		sbUrl.append("</script>");
		this.setPageBar(sbUrl.toString());
	}
}
