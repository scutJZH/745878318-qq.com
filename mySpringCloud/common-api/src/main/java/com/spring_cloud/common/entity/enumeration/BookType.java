package com.spring_cloud.common.entity.enumeration;

import lombok.Getter;

@Getter
public enum BookType {
    COMPUTER_TECHNOLOGY(1, "COMPUTER_TECHNOLOGY", "计算机科学与技术"),
    EDUCATION(2, "EDUCATION", "教育"),
    NOVEL(3, "NOVEL", "小说"),
    PROSE(4, "PROSE", "散文"),
    ;

    private Integer typeId;
    private String type;
    private String desc;

    BookType(Integer typeId, String type, String desc) {
        this.typeId = typeId;
        this.type = type;
        this.desc = desc;
    }

    public static BookType getBookType(String type) {
        for(BookType bookType : values()) {
            if(bookType.getType().equals(type)) {
                return bookType;
            }
        }
        return null;
    }

    public static BookType getBookType(Integer typeId) {
        for(BookType bookType : values()) {
            if(bookType.getTypeId().equals(typeId)) {
                return bookType;
            }
        }
        return null;
    }

}
