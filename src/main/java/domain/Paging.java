package domain;

import persistance.RentalManagementRepository;

public class Paging {
    private final static int pageCount = 10;
    private int blockStartNum = 0;
    private int blockLastNum = 0;
    private int lastPageNum = 0;

    public static int getPageCount() {
        return pageCount;
    }

    public int getBlockStartNum() {
        return blockStartNum;
    }

    public void setBlockStartNum(int blockStartNum) {
        this.blockStartNum = blockStartNum;
    }

    public int getBlockLastNum() {
        return blockLastNum;
    }

    public void setBlockLastNum(int blockLastNum) {
        this.blockLastNum = blockLastNum;
    }

    public int getLastPageNum() {
        return lastPageNum;
    }

    public void setLastPageNum(int lastPageNum) {
        this.lastPageNum = lastPageNum;
    }

    public void makeBlock(int curPage) {
        int blockNum = 0;
        blockNum = (int) Math.floor((curPage - 1)) / pageCount;
        blockStartNum = (pageCount + blockNum) + 1;
        blockLastNum = blockStartNum + (pageCount - 1);
    }

    public void makeLastPageNum() {
        RentalManagementRepository rental = new RentalManagementRepository();
        int total = rental.getCount();

        if (total % pageCount == 0) {
            lastPageNum = (int) Math.floor(total / pageCount);
        } else {
            lastPageNum = (int) Math.floor(total / pageCount) + 1;
        }
    }
}
