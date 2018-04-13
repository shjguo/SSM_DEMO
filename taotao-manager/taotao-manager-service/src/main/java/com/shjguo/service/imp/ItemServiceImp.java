package com.shjguo.service.imp;

import com.shjguo.mapper.TbItemMapper;
import com.shjguo.pojo.TbItem;
import com.shjguo.pojo.TbItemExample;
import com.shjguo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    @Override
    public TbItem getItemById(Long itemId) {
        TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria =example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list = tbItemMapper.selectByExample(example);
        if(list !=null && list.size() >0){
            return item;
        }
        return null;
    }
}
