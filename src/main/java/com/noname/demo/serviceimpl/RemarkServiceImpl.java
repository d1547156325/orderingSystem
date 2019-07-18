package com.noname.demo.serviceimpl;

import com.noname.demo.entity.Remark;
import com.noname.demo.mapper.RemarkMapper;
import com.noname.demo.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RemarkServiceImpl implements RemarkService {
    @Autowired
    private RemarkMapper remarkMapper=null;
    @Override
    public List<Remark> findAllRemark() {
        return remarkMapper.findAll();
    }

    @Override
    public int intsertRemark(Remark remark) {
        return remarkMapper.insertSelective(remark);
    }
}
