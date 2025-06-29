package com.Lcode.community.entity;

public class Page {
    private int current = 1;
    private int limit = 10;
    private int totalLine;

    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 0 && limit <= 100)
        {
            this.limit = limit;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(int totalLine) {
        this.totalLine = totalLine;
    }

    /**
     * 获取当前页的起始行
     * @return
     */
    public int getStartId()
    {
        return current*limit - limit;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotalPage()
    {
        if (totalLine % limit == 0)
        {
            return totalLine/limit;
        }
        else {
            return totalLine/limit + 1;
        }
    }

    /**
     * 范围初始页
     * @return
     */
    public int from()
    {
        return current - 2 > 0 ? current - 2 : 1;
    }

    /**
     * 范围终止页
     * @return
     */
    public int to()
    {
        return current + 2 < getTotalPage() ? current + 2 : getTotalPage();
    }
}
