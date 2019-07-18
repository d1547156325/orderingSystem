package com.noname.demo.service;


import com.noname.demo.entity.Remark;

import java.util.List;

public interface RemarkService {
    List<Remark> findAllRemark();
    int intsertRemark(Remark remark);
}
