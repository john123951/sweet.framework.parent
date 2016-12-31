package sweet.framework.service.impl;

import org.springframework.stereotype.Service;
import sweet.framework.service.IUserService;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public Date getTime() {
        return new Date();
    }
}
