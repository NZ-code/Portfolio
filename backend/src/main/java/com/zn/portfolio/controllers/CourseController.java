package  com.zn.portfolio.controllers;

import com.zn.portfolio.entities.Course;
import com.zn.portfolio.services.CourseService;
import com.zn.portfolio.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = Constants.CORS)
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("/api/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/api/courses/{courseId}")
    public Course getCourse(@PathVariable(name="courseId") String id){
        return courseService.getCourse(id);
    }
    @PostMapping("/api/courses")
    public void saveCourse(@RequestBody Course course){
        courseService.createCourse(course);
    }
    @DeleteMapping("/api/courses/{courseId}")
    public void deleteCourse(@PathVariable(name = "courseId") String id){
        courseService.deleteCourse(id);
    }
    @PutMapping("/api/courses/{courseId}")
    public void updateCourse(@PathVariable(name = "courseId") String id,
                              @RequestBody Course course){

        courseService.updateCourse(id, course);
    }

}
