package ru.sadikov.dz.magafondz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.sadikov.dz.magafondz.Reprository.IUsersRepository;
import ru.sadikov.dz.magafondz.models.Role;
import ru.sadikov.dz.magafondz.models.Users;

import java.util.List;
import java.util.Optional;

@Service
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private IUsersRepository iUsersRepository;


    @Override
    public List<Users> getAllUsers() {
        return iUsersRepository.findAll();
    }

    @Override
    public void saveUsers(Users users) {
    this.iUsersRepository.save(users);

    }

    @Override
    public Users getUsersById(Integer id) {
        Optional<Users> optional = iUsersRepository.findById(id);
        Users users1 = null;
        if(optional.isPresent()){
            users1 = optional.get();
        }
        else {
            throw new RuntimeException("User not found for Id :: "+id);
        }
        return users1;
    }

    @Override
    public void deleteUsersById(Integer id) {
        this.iUsersRepository.deleteById(id);

    }

    @Override
    public Page<Users> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.iUsersRepository.findAll(pageable);
    }
}
