package com.cognizant.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.quiz.model.Attempt;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt,Integer> {

	
	@Query(value="Select a from User u left join u.attemptList a "
			+ "left join fetch a.questionList q join fetch a.optionList ql "
			+ " left join fetch q.attemptList al left join fetch q.optionsList ol"
			+ "left join fetch ql.attemptList al left join fetch ql.attemptOptionList ail where u.us_id=:usId and a.at_id=:atId order by q.qt_id ASC")
	public Attempt getAttemptList(@Param(value="usId")int usId,@Param(value="atId")int atId);
	
}
