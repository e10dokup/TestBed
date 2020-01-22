package dev.dokup.testbed.infra.expense

import dagger.Binds
import dagger.Module
import dev.dokup.testbed.domain.expense.ExpenseRepository

@Module
interface ExpenseRepositoryModule {
    @Binds
    fun bindRepository(repositoryImpl: ExpenseRepositoryImpl): ExpenseRepository
}
