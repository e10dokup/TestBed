package dev.dokup.testbed.di

import dagger.Module
import dev.dokup.testbed.infra.expense.ExpenseRepositoryModule

@Module(
    includes = [
        ExpenseRepositoryModule::class
    ]
)
interface RepositoryModule
